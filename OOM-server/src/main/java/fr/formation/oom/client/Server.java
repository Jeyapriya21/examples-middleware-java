/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.formation.oom.client;

import fr.formation.oom.client.service.RemoteImpl;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ryank
 */
public class Server {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        try {
            Registry registry = LocateRegistry.createRegistry(18500);
            RemoteImpl remote ;
            remote = new RemoteImpl();
            String rebindName= "remote";
            registry.rebind(rebindName, remote);
            System.out.println("Object Remote is Done !");
            
        } catch (RemoteException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
