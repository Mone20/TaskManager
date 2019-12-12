/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taskmanager;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import static taskmanager.Server.SOCKET_CLOSE;

/**
 *
 * @author Rodion
 */
public class ThreadServerPart extends Thread {
private final Socket clientSocket;
private final TaskController controller;
public ThreadServerPart(Socket s,TaskController c)
     {
         this.clientSocket=s;
         this.controller=c;
     }
    @Override
    public void run() 
    {
           try {
                    DataInputStream in; 
                    DataOutputStream out;
                    in = new  DataInputStream(clientSocket.getInputStream());
                    out = new DataOutputStream(clientSocket.getOutputStream());
                    System.out.println("Server reading from channel");
                    int numOfTask=0;
                    int isNotification=0;
                  
               while (numOfTask!=Server.EXIT)
                       {
                    numOfTask=in.read();
                    System.out.println("READ from Log - Task№"+numOfTask);
                    System.out.println("Server try writing to channel");
                    ObjectOutputStream objectOut = new ObjectOutputStream(out);
                        
                    objectOut.writeObject(controller.getLog().get(numOfTask));
                    out.flush();
                    out.write(isNotification);
                    out.flush();
                    
                       }
                    out.writeInt(SOCKET_CLOSE);
                    System.out.println("client closed");
                    clientSocket.close();
                    in.close();
                    out.close();
                    } catch (IOException ex) {
                            Logger.getLogger(ThreadServerPart.class.getName()).log(Level.SEVERE, null, ex);
                        }
    }
    


    
}
    

