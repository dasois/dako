package edu.hm.dako.echo.connection.udp;

import edu.hm.dako.echo.connection.Connection;

import java.io.IOException;
import java.io.Serializable;

public class UdpServerConnection implements Connection {

    private UdpSocket serverSocket;

    private UdpRemoteObject udpRemoteObject;
    
    // DONE Studienarbeit: Ergaenzen des Konstruktors und der fehlenden Methoden receive und send; dabei udpRemoteObject nutzen
    // Daten aus dem UdpSocket zwischenspeichern, damit es fuer weitere Verbindungsanfragen verwendet werden kann
    
    public UdpServerConnection(UdpSocket serverSocket) throws Exception {

        this.serverSocket = serverSocket;
		Serializable pdu = (Serializable) serverSocket.receive(0);
        udpRemoteObject = new UdpRemoteObject(serverSocket.getRemoteAddress(), serverSocket.getRemotePort(), pdu);
     
		
	
    	
   }

	@Override
	public Serializable receive() throws Exception {
		return (Serializable) udpRemoteObject.getObject();
	}

	@Override
	public void send(Serializable message) throws Exception {
		serverSocket.send(udpRemoteObject.getRemoteAddress(),udpRemoteObject.getRemotePort(),message);
	}

	@Override
	public void close() throws Exception {
	//nicht benutzen
	}
}
