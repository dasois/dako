package edu.hm.dako.echo.connection.udp;

import edu.hm.dako.echo.connection.Connection;
import edu.hm.dako.echo.connection.ConnectionFactory;

import java.net.InetAddress;

public class UdpClientConnectionFactory implements ConnectionFactory {

    @Override
    public Connection connectToServer(String remoteServerAddress, int serverPort, int localPort) throws Exception {
    	//TODO Studienarbeit: UDP-Socket erzeugen, Verbindungsparameter setzen und UDP-Verbindung erzeugen 
    	//Hinweis: Empfangspuffer: 2000 Byte, Sendepuffer: 3000 Byte
    	
    	
    }
}
