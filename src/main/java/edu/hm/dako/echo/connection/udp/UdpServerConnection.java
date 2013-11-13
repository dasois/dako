package edu.hm.dako.echo.connection.udp;

import edu.hm.dako.echo.connection.Connection;

import java.io.IOException;
import java.io.Serializable;

public class UdpServerConnection implements Connection {

    private UdpSocket serverSocket;

    private UdpRemoteObject udpRemoteObject;
    
    // Studienarbeit: Ergaenzen des Konstruktors und der fehlenden Methoden receive und send; dabei udpRemoteObject nutzen
    
    public UdpServerConnection(UdpSocket serverSocket) throws Exception {

        this.serverSocket = serverSocket;
        udpRemoteObject = new UdpRemoteObject(serverSocket.getRemoteAddress(),serverSocket.getRemotePort(),  receive() );
    	
    	// Daten aus dem UdpSocket zwischenspeichern, damit es fuer weitere Verbindungsanfragen verwendet werden kann
       
    	
    }

	@Override
	public Serializable receive() throws Exception {
		
		serverSocket.receive(timeout);
	//TODO  Auto-generated method stub
	}

	@Override
	public void send(Serializable message) throws Exception {
		serverSocket.send(udpRemoteObject.getRemoteAddress(),udpRemoteObject.getRemotePort(),message);
		//  Auto-generated method stub
		
	}

	@Override
	public void close() throws Exception {
		serverSocket.close();
		
	}

}
