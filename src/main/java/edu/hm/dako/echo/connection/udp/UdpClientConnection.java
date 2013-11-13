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
    	//DONE: Studienarbeit: Nachricht mit Timeout empfangen und an Aufrufer zurueckgeben
    	return (Serializable) clientSocket.receive(receivingTimeout);
    }

    @Override
    public void send(Serializable message) throws Exception {
    	//DONE: Studienarbeit: Nachricht an Partner versenden
    	clientSocket.send(clientSocket.getRemoteAddress(),clientSocket.getRemotePort(),message);
    }

    @Override
    public void close() throws IOException {
    	//DONE: Studienarbeit: Socket schliessen
    	clientSocket.close();
    }
}
