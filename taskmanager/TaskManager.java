/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.taskmanager;

import com.company.userview.UserInterface;

import java.io.IOException;
import java.io.Serializable;
import java.sql.Time;
import java.text.ParseException;

/**
 *
 * @author Rodion
 */
public class TaskManager implements Serializable {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException, ParseException {
        // TODO code application logic here
        UserInterface TaskManager=new UserInterface();
        TaskManager.mainUserInterface();
        }
    
}
