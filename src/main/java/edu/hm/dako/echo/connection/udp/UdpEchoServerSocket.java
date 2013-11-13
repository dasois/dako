package edu.hm.dako.echo.connection.udp;

import edu.hm.dako.echo.connection.Connection;
import edu.hm.dako.echo.connection.ServerSocket;

import java.io.IOException;
import java.net.SocketException;

public class UdpEchoServerSocket implements ServerSocket {

    private final UdpSocket socket;
    
    public UdpEchoServerSocket(int serverPort) throws SocketException {
    	// Puffergroessen muessen fuer die Lasttests so belassen werden
        this.socket = new UdpSocket(serverPort, 2000, 5000);
    }

	@Override
	public Connection accept() throws Exception {
		return new UdpServerConnection(socket);
		
	}

	@Override
	public void close() throws Exception {
		socket.close();
		// Auto-generated method stub
		
	}

	@Override
	public boolean isClosed() {
		return socket.isClosed();
		// Auto-generated method stub
	
	}

    // Studienarbeit: Alle erforderlichen Methoden ergaenzen
    
    
    
    
    
    
    
    
    
    
    
}
