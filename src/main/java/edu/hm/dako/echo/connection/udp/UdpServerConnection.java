package edu.hm.dako.echo.connection.udp;

import edu.hm.dako.echo.connection.Connection;

import java.io.IOException;
import java.io.Serializable;

public class UdpServerConnection implements Connection {

	private UdpSocket serverSocket;

	private UdpRemoteObject udpRemoteObject;

	// DONE Studienarbeit: Ergaenzen des Konstruktors und der fehlenden Methoden receive und send; dabei udpRemoteObject nutzen

	/**
	 * Dient dem Kommunikationsaufbau über das UDP Protokol
	 * @param serverSocket Über diesen Socket soll in verwendung von UDP kommuniziert werden.
	 * @throws Exception Fehler in der Verbindung
	 */
	public UdpServerConnection(UdpSocket serverSocket) throws IOException {
		//DONE Daten aus dem UdpSocket zwischenspeichern, damit es fuer weitere Verbindungsanfragen verwendet werden kann

		this.serverSocket = serverSocket;
		Serializable pdu = (Serializable) serverSocket.receive(0);
		udpRemoteObject = new UdpRemoteObject(serverSocket.getRemoteAddress(), serverSocket.getRemotePort(), pdu);




	}

	/** Blockiert bis eine Nachricht eintrifft.	 */
	public Serializable receive() throws Exception {
		return (Serializable) udpRemoteObject.getObject();
	}

	/** Sendet eine Nachricht an den Kommunikationspartner über UDP. */
	public void send(Serializable message) throws Exception {
		serverSocket.send(udpRemoteObject.getRemoteAddress(),udpRemoteObject.getRemotePort(),message);
	}

	/** Baut die Verbindung zum Kommunikationspartner ab. */
	public void close() throws Exception {
		//nicht benutzen
	}
}
