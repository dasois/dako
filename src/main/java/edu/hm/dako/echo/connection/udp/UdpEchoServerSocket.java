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
    
    // DONE: Studienarbeit: Alle erforderlichen Methoden ergaenzen

    // Die erforderlichen Methoden sind accept(), close() und isClosed().
    
    
	/**
	 * Legt die Art der Kommunikation fest und ermöglicht die Kontaktaufnahme .
	 * @return UdpServerConnection gibt eine UDP-verbindung zurück.
	 * @throws Exception wird geworfen wenn der Verbindungspunkt nicht Ordnungsgemäß erstellt werden kann.
	 */
	public Connection accept() throws Exception {
		return new UdpServerConnection(socket);
	}

	
	/**
	 * Schliesst den Socket und wird beim Herunterfahren des Servers aufgerufen.
	 * @throws Exception wird geworfen wenn der Socket nicht geschlossen werden kann.
	 */
	public void close() throws Exception {
		socket.close();		
	}

	/**
	 * Gibt zurueck ob der Socket schon geschlossen ist oder nicht.
	 * @return boolean true, falls der Socket schon geschlossen ist.
	 */
	public boolean isClosed() {
		return socket.isClosed();
	}
}
