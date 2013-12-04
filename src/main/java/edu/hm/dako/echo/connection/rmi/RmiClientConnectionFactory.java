package edu.hm.dako.echo.connection.rmi;

import edu.hm.dako.echo.connection.Connection;
import edu.hm.dako.echo.connection.ConnectionFactory;
import edu.hm.dako.echo.server.rmi.RMIEchoServerRemote;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.rmi.Naming;
import java.rmi.Remote; //DONE

public class RmiClientConnectionFactory implements ConnectionFactory {

    @Override
    public Connection connectToServer(String remoteServerAddress, int serverPort, int localPort) throws Exception {
    	
    	//DONE Studienarbeit: Lookup durchfuehren und RMI-Connection erzeugen
		Remote remote = Naming.lookup( "rmi://" + remoteServerAddress + "/RMIEchoServer");
     	RmiConnection rcon = new RmiConnection((RMIEchoServerRemote) remote);
     	return rcon;
    }
}
