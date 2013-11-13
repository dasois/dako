package edu.hm.dako.echo.connection.udp;

import edu.hm.dako.echo.connection.Connection;

import java.io.IOException;
import java.io.Serializable;

public class UdpClientConnection implements Connection {

	// UDP-Socket der Verbindung
    private UdpSocket clientSocket;

    /**
     * Timeout fuer {@link UdpSocket#receive(int)}
     */
    private final int receivingTimeout;

    // weglassen alle Override-Methoden und Inhalt des Konstruktors
    
    public UdpClientConnection(UdpSocket clientSocket, int receivingTimeout) throws Exception {
    	
    	this.clientSocket = clientSocket;
    	this.receivingTimeout = receivingTimeout;
    	// Studienarbeit: Parameter uebernehmen
    
    	
    }

    @Override
    public Serializable receive() throws Exception {
    	
    	return (Serializable) clientSocket.receive(receivingTimeout);
    	
    	// Studienarbeit: Nachricht mit Timeout empfangen und an Aufrufer zurueckgeben
        
    	
    }

    @Override
    public void send(Serializable message) throws Exception {
    	clientSocket.send(clientSocket.getRemoteAddress(),clientSocket.getRemotePort(),message);
    	
    	
    	// Studienarbeit: Nachricht an Partner versenden
      
    	
    }

    @Override
    public void close() throws IOException {
    	
    	clientSocket.close();
    	// Studienarbeit: Socket schliessen
       
    }

}
