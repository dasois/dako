package edu.hm.dako.echo.server.rmi;


import edu.hm.dako.echo.common.EchoPDU;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Remote-Interface fuer Echo-Server
 *
 * @author Mandl
 */
public interface RMIEchoServerRemote extends Remote {
    public EchoPDU echo(EchoPDU message)
            throws RemoteException;
}
