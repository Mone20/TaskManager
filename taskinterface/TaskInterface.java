/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taskinterface;

import taskmanager.TaskNode;

import java.io.IOException;
import java.util.Date;

/**
 *
 * @author Rodion
 */
public interface TaskInterface {
    void createTask(String name,String description,Date date,String number);
    void deleteTask(TaskNode object);
    void exit()throws IOException;
    
}
