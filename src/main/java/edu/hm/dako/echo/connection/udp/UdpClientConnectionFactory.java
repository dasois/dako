package edu.hm.dako.echo.connection.udp;

import edu.hm.dako.echo.connection.Connection;
import edu.hm.dako.echo.connection.ConnectionFactory;

import java.net.InetAddress;

public class UdpClientConnectionFactory implements ConnectionFactory {
	
	//DONE Studienarbeit: UDP-Socket erzeugen, Verbindungsparameter setzen und UDP-Verbindung erzeugen 
	//Hinweis: Empfangspuffer: 2000 Byte, Sendepuffer: 3000 Byte
    @Override
    public Connection connectToServer(String remoteServerAddress, int serverPort, int localPort) throws Exception {
    	
		UdpSocket clientSocket = new UdpSocket(localPort,3000,2000);
		InetAddress serverAdd = InetAddress.getByName( remoteServerAddress );

		clientSocket.setRemoteAddress(serverAdd);
		clientSocket.setRemotePort(serverPort);
		UdpClientConnection Connection = new UdpClientConnection(clientSocket,0);
    	return Connection;
    }
}
