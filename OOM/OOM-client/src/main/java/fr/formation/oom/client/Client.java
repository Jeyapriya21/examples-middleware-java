/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.formation.oom.client;

import fr.formation.oom.client.service.RemoteInterface;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ryank
 */
public class Client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        try {
            String serverAdress = "localhost";
            Registry registry = LocateRegistry.getRegistry(serverAdress, 18500);
            RemoteInterface remote = (RemoteInterface) registry.lookup("remote");
            System.out.println("Connection OK to " + serverAdress);
            String msg = remote.HeloWorld();
            System.out.println(msg);
        } catch (RemoteException | NotBoundException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
