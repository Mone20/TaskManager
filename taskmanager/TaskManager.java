/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taskmanager;


import java.io.IOException;
import java.io.Serializable;
import java.text.ParseException;
import org.xml.sax.SAXException;
import userview.UserInterface;

import javax.xml.parsers.ParserConfigurationException;

/**
 *
 * @author Rodion
 */
public class TaskManager implements Serializable {

    /**
     * @param args the command line arguments
     * @throws IOException
     * @throws ClassNotFoundException
     * @throws ParseException
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException, ParseException, InterruptedException, ParserConfigurationException, SAXException {
        // TODO code application logic here
        UserInterface TaskManager=new UserInterface();
        TaskManager.mainUserInterface();
}
    
}
