package edu.hm.dako.echo.server;

import edu.hm.dako.echo.common.EchoPDU;
import edu.hm.dako.echo.connection.Connection;
import edu.hm.dako.echo.connection.ServerSocket;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.PropertyConfigurator;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

public class DefaultEchoServerImpl implements EchoServer {

    private static Log log = LogFactory.getLog(DefaultEchoServerImpl.class);

    private final ExecutorService executorService;

    private ServerSocket socket;

    private final boolean singleConnectionForClient;

    public DefaultEchoServerImpl(ExecutorService executorService, ServerSocket socket, boolean singleConnectionForClient) {
        this.singleConnectionForClient = singleConnectionForClient;
        this.executorService = executorService;
        this.socket = socket;
    }

    @Override
    public void start() {
        PropertyConfigurator.configureAndWatch("log4j.server.properties", 60 * 1000);
        System.out.println("Echoserver wartet auf Clients...");
        while (!Thread.currentThread().isInterrupted() && !socket.isClosed()) {
            try {
                // Auf ankommende Verbindungsaufbauwuensche warten
                Connection connection = socket.accept();

                // Neuen Workerthread starten
                executorService.submit(new EchoWorker(connection));
                //DEBUG: System.out.println("Echo-Worker gestartet.");
            } catch (Exception e) {
                log.error("Exception beim Entgegennehmen von Verbindungswuenschen: " + e);
            }
        }
    }

    @Override
    public void stop() throws Exception {
        System.out.println("EchoServer beendet sich");
        Thread.currentThread().interrupt();
        socket.close();
        executorService.shutdown();
        try {
            executorService.awaitTermination(10, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            log.error("Das beenden des ExecutorService wurde unterbrochen");
            e.printStackTrace();
        }
    }

    private class EchoWorker implements Runnable {

        private final Connection con;

        private boolean finished = false;

        long startTime;

        private EchoWorker(Connection con) {
            this.con = con;
        }

        @Override
        public void run() {
            while (!finished && !Thread.currentThread().isInterrupted()) {
                try {
                    echo();
                } catch (Exception e) {
                    closeConnection();
                    throw new RuntimeException(e);
                }
            }
            log.debug(Thread.currentThread().getName() + " beendet sich");
            closeConnection();
        }

    	/* TODO Studienarbeit: Methode echo zum Empfang und Senden einer Echo-Nachricht schreiben.
         * Hinweis: 
         * Bei einem multi-threaded Server ist hier auch zu pruefen, 
         * ob der letzte Request eines Clients empfangen wird. 
         * Wenn ja, ist das Kennzeichen "finished" zu setzen.
         * Weiterhin ist die Zeitmessung fuer die Requestbearbeitung einzubauen.
         */
        private void echo() throws Exception {
        	EchoPDU receivedPdu = (EchoPDU) con.receive();
        	startTime = System.nanoTime();	//oder schon vorher?
        	EchoPDU responsePdu = EchoPDU.createServerEchoPDU(receivedPdu, startTime);
        	responsePdu.setMessage("Server: Copy!");
			con.send(responsePdu);
			finished = receivedPdu.getLastRequest()||singleConnectionForClient;
        }

        private void closeConnection() {          
           	//TODO Studienarbeit: Verbindung schliessen
			try {
				con.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
    }
}
