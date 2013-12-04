package edu.hm.dako.echo.connection.rmi;

import edu.hm.dako.echo.connection.Connection;
import edu.hm.dako.echo.connection.ConnectionFactory;
import edu.hm.dako.echo.server.rmi.RMIEchoServerRemote;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.rmi.Naming;

public class RmiClientConnectionFactory implements ConnectionFactory {

    @Override
    public Connection connectToServer(String remoteServerAddress, int serverPort, int localPort) throws Exception {
    	
    	//DONE Studienarbeit: Lookup durchfuehren und RMI-Connection erzeugen
    	RMIEchoServerRemote remote = (RMIEchoServerRemote) Naming.lookup( "rmi://" + remoteServerAddress + "/RMIEchoServer");
     	RmiConnection rcon = new RmiConnection(remote);
     	return rcon;
    }
}
