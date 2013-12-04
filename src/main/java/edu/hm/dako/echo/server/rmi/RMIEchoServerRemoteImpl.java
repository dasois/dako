package edu.hm.dako.echo.server.rmi;


import edu.hm.dako.echo.common.EchoPDU;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RMIEchoServerRemoteImpl extends UnicastRemoteObject implements RMIEchoServerRemote {
    private static final long serialVersionUID = 99L;
    private static Log log = LogFactory.getLog(RMIEchoServerRemoteImpl.class);

    public RMIEchoServerRemoteImpl() throws RemoteException {
    }

	//DONE Studienarbeit: Methode echo programmieren
    public EchoPDU echo(EchoPDU message) throws RemoteException {
    	
    	long startTime = System.nanoTime();
		return EchoPDU.createServerEchoPDU(message, startTime);
    	
    	
    	
    }
}