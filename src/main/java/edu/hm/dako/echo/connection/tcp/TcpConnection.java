package edu.hm.dako.echo.connection.tcp;

import edu.hm.dako.echo.connection.Connection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.net.SocketException;

public class TcpConnection implements Connection {

    private static Log log = LogFactory.getLog(TcpConnection.class);

    // Groesse des Empfangspuffers einer TCP-Verbindung in Byte
    private static final int RECEIVE_BUFFER_SIZE = 300000;

    // Ein- und Ausgabestrom der Verbindung
    private final ObjectOutputStream out;
    private final ObjectInputStream in;
    
    // Verwendetes TCP-Socket
    private final Socket socket;
    /**
     * Dient dem Kommunikationsaufbau über das TCP Protokol.
     * @param socket Über diesen Socket soll in verwendung von TCP kommuniziert werden.
     */
    public TcpConnection(Socket socket) {
        this.socket = socket;

        log.info(Thread.currentThread().getName() + ": Verbindung mit neuem Client aufgebaut, Remote-TCP-Port " +
                socket.getPort());

        try {
        	//DONE Studienarbeit: Objektstreams fuer die Ein- und Ausgabe erzeugen
        	out = new ObjectOutputStream(this.socket.getOutputStream());	//Öffnen eines Ausgabestroms
        	in = new ObjectInputStream(this.socket.getInputStream());	//Öffnen eines EIngabestroms

            log.debug("Standardgroesse des Empfangspuffers der Verbindung: " + socket.getReceiveBufferSize() +
                    " Byte");
            socket.setReceiveBufferSize(RECEIVE_BUFFER_SIZE);
            log.debug("Eingestellte Groesse des Empfangspuffers der Verbindung: " + socket.getReceiveBufferSize() +
                    " Byte");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /** Blockiert bis eine Nachricht eintrifft.
     * @return Serializable Das erhaltene Serializable-Objekt
     */
    public Serializable receive() throws Exception {
    	//DONE Studienarbeit: Nachricht aus dem Eingabestrom lesen und als Returnwert zurueckgeben
    	return (Serializable) in.readObject();
    }

    /** Sendet eine Nachricht an den Kommunikationspartner.
     * @param Die zu sendende Nachricht.     */
    public void send(Serializable message) throws Exception {
    	//DONE Studienarbeit: Nachricht in den Ausgabestrom schreiben
    	out.writeObject(message);
    	out.flush();
    }

    /** Baut die Verbindung zum Kommunikationspartner ab. */
    public void close() throws IOException {
    	//DONE Studienarbeit: Ausgabestrom leeren (flush) und Verbindung schliessen 
    	out.flush();
    	out.close();
    }
}
