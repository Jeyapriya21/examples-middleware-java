/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.formation.jms.queue.receiver;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;
import org.apache.qpid.jms.JmsConnectionFactory;

/**
 *
 * @author ryank
 */
public class Consumer {

    /**
     * @param args the command line arguments
     * @throws javax.jms.JMSException
     */
    public static void main(String[] args) throws JMSException {
        JmsConnectionFactory factory = new JmsConnectionFactory("amqp://localhost:5672");
        try (Connection connection = factory.createConnection("admin", "admin")) {
            connection.start();

            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

            Destination destination = session.createQueue("MyQueue");
//            if (args.length > 0 && args[0].equalsIgnoreCase("QUEUE")) {
//                destination = session.createQueue("MyQueue");
//            } else if (args.length > 0 && args[0].equalsIgnoreCase("TOPIC")) {
//                destination = session.createTopic("MyTopic");
//            } else {
//                System.out.println("Error: You must specify Queue or Topic");
//                connection.close();
//                System.exit(1);
//            }

            MessageConsumer consumer = session.createConsumer(destination);
//
            String body;
//            do {
//
                Message msg = consumer.receive();
                body = ((TextMessage) msg).getText();
//
                System.out.println("Received = " + body);
//
//            } while (!body.equalsIgnoreCase("SHUTDOWN"));
        }
        //System.exit(1);
    }
}
