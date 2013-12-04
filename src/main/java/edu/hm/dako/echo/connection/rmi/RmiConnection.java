package edu.hm.dako.echo.connection.rmi;

import edu.hm.dako.echo.common.EchoPDU;
import edu.hm.dako.echo.connection.Connection;
import edu.hm.dako.echo.server.rmi.RMIEchoServerRemote;

import java.io.Serializable;

public class RmiConnection implements Connection {

    // RMI-Referenz auf den Server
    private RMIEchoServerRemote echoServer;

    private EchoPDU receivedPdu;

    public RmiConnection(RMIEchoServerRemote echoServer) {
        this.echoServer = echoServer;
    }

    @Override
    public EchoPDU receive() throws Exception {
        return receivedPdu;
    }

    @Override
    public void send(Serializable message) throws Exception {
    	//DONE Studienarbeit: Aufruf der entfernten Echo-Methode
    	receivedPdu = echoServer.echo((EchoPDU) message);
    }

    @Override
    public void close() throws Exception {
    }
}
