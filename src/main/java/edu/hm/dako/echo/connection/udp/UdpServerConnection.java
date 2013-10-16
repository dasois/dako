package edu.hm.dako.echo.connection.udp;

import edu.hm.dako.echo.connection.Connection;

import java.io.IOException;
import java.io.Serializable;

public class UdpServerConnection implements Connection {

    private UdpSocket serverSocket;

    private UdpRemoteObject udpRemoteObject;
    
    //TODO Studienarbeit: Ergaenzen des Konstruktors und der fehlenden Methoden receive und send; dabei udpRemoteObject nutzen
    
    public UdpServerConnection(UdpSocket serverSocket) throws Exception {

        
    	
    	// Daten aus dem UdpSocket zwischenspeichern, damit es fuer weitere Verbindungsanfragen verwendet werden kann
       
    	
    }

}
