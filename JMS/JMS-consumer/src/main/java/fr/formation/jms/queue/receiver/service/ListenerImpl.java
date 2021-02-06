package fr.formation.jms.queue.receiver.service;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 *
 * @author ryank
 */
public class ListenerImpl implements MessageListener, ListenerInterface {

    @Override
    public void onMessage(Message msg) {
        try {
            TextMessage myTextMsg = (TextMessage) msg;

            System.out.println("following message is received:" + myTextMsg.getText());
            
        } catch (JMSException e) {
            System.out.println(e);
        }
    }

}
