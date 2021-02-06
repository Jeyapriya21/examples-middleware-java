/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.formation.oom.client.service;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author ryank
 */
public interface RemoteInterface extends Remote{
      public String HelloWorld() throws RemoteException;
}
