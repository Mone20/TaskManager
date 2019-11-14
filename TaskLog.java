/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taskmanager;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Rodion
 */
public class TaskLog implements TaskInterface {
    public static String path="myfile";
    private ArrayList <TaskNode> TaskList;
    public TaskLog() throws IOException, ClassNotFoundException 
    {
        FileInputStream in=new FileInputStream(path);
        ObjectInputStream objectIn = new ObjectInputStream(in);
        TaskLog tl=(TaskLog)objectIn.readObject();
        this.TaskList=tl.TaskList;
        
    }
    public ArrayList<TaskNode> getTaskList()
    {
        return this.TaskList;
    }
    @Override
    public void createTask(String name,String description,Date date,String number)
    {
        TaskNode task=new TaskNode(name,description,date,number);
        this.TaskList.add(task);
    }
    @Override
    public void deleteTask(TaskNode object) throws IllegalArgumentException 
    {
       
        this.TaskList.remove(object);
        
    }
    @Override
     public void exit() throws IOException {
         try{
        FileOutputStream out= new FileOutputStream(path);      
        ObjectOutputStream objectOut = new ObjectOutputStream(out);
        objectOut.writeObject(this);
        out.flush();
         }catch(IOException ioe){
          ioe.printStackTrace();}
    }
      
}
