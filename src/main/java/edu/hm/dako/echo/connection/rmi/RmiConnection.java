package edu.hm.dako.echo.connection.rmi;

import edu.hm.dako.echo.common.EchoPDU;
import edu.hm.dako.echo.connection.Connection;
import edu.hm.dako.echo.server.rmi.RMIEchoServerRemote;

import java.io.Serializable;

public class RmiConnection implements Connection {

    // RMI-Referenz auf den Server
    private RMIEchoServerRemote echoServer;
    /** @param receivedPdu hinterlegt die Antwortnachricht*/
    private EchoPDU receivedPdu;

    public RmiConnection(RMIEchoServerRemote echoServer) {
        this.echoServer = echoServer;
    }

    @Override
    public EchoPDU receive() throws Exception {
        return receivedPdu;
    }

   /** Empf�ngt eine Nachricht und erstellt die Antwort.
    * @param message Nachricht die die Serverseite empf�ngt.
    * @throws Exception Steht f�r eine vielzahl von Exceptions die beim Remoteprozess auftretten k�nnen.*/
    public void send(Serializable message) throws Exception {
    	//DONE Studienarbeit: Aufruf der entfernten Echo-Methode
    	
    	
    	receivedPdu = echoServer.echo((EchoPDU) message);
    }

    @Override
    public void close() throws Exception {
    }
}
