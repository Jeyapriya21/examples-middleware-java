/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.formation.jms.queue.sender;

import java.io.Console;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.qpid.jms.JmsConnectionFactory;

/**
 *
 * @author ryank
 */
public class Producer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {

            JmsConnectionFactory factory = new JmsConnectionFactory("amqp://localhost:5672");
            Connection connection = factory.createConnection("admin", "admin");

            //    ConnectionFactory factory = new ActiveMQConnectionFactory(ActiveMQConnection.DEFAULT_BROKER_URL);
            // Connection connection = factory.createConnection() ;
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

          
            MessageProducer producer = session.createProducer(destination);

//           
//            Console c = System.console();
//            String response;
//       //     do {
//
//               // response = c.readLine("Enter message: ");
                TextMessage msg = session.createTextMessage("test");
                producer.send(msg);
//
//          //  } while (!response.equalsIgnoreCase("SHUTDOWN"));
//
//      
//            connection.close();
//            System.exit(1);

        } catch (JMSException ex) {
            Logger.getLogger(Producer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
