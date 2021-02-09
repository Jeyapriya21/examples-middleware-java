/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.formation.oom.client.service;

import java.rmi.RemoteException;
import java.rmi.server.RMIClientSocketFactory;
import java.rmi.server.RMIServerSocketFactory;
import java.rmi.server.UnicastRemoteObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author ryank
 */

public class RemoteImpl extends UnicastRemoteObject implements RemoteInterface {

    protected final Logger log = LoggerFactory.getLogger(getClass());
    
    @Override
    public String HelloWorld() throws RemoteException {
        return "Babidi";
    }

    public RemoteImpl() throws RemoteException {
        super();
    }

    public RemoteImpl(int port) throws RemoteException {
        super(port);
    }

    public RemoteImpl(int port, RMIClientSocketFactory csf, RMIServerSocketFactory ssf) throws RemoteException {
        super(port, csf, ssf);
    }

}
