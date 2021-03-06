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
    
    /**
     * Erstellen der Echo-Nachricht die geantwortet wird.
     * @return EchoPDU Echo-Nachricht die geantwortet wird.
     * @throws RemoteException Steht f�r eine vielzahl von Fehlern die bei einem Remote Methodenaufruf auftretten kann.
     */
    public EchoPDU echo(EchoPDU pdu) throws RemoteException {
    	EchoPDU pduresponse = EchoPDU.createServerEchoPDU(pdu, System.nanoTime());
    	log.debug("EchoObject on RMI-Server created.");
    	return pduresponse;
	}
}