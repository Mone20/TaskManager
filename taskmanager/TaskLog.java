/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taskmanager;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Rodion
 */
public class TaskLog  {
    public static String path="myfile";
    private ArrayList <TaskNode> TaskList;
    public TaskLog() throws IOException, ClassNotFoundException 
    {
        File f=new File(path);
        if(f.exists())
        {
         if(f.length()!=0)
         {
        FileInputStream in=new FileInputStream(f);
        ObjectInputStream objectIn = new ObjectInputStream(in);
        TaskLog tl=(TaskLog)objectIn.readObject();
        this.TaskList=tl.TaskList;
         }
         else
         {
             this.TaskList=new ArrayList<TaskNode>();
             
         }
        }
        else
        {
            
            if(f.createNewFile())
            {
              this.TaskList=new ArrayList<TaskNode>();
            }
            else
            {
                System.out.printf("Error");
            }
                
        }
        
    }
    public ArrayList<TaskNode> getTaskList()
    {
        return this.TaskList;
    }
    
    public void createTask(TaskNode task)
    {
       
        this.TaskList.add(task);
        
    }
  
    public void deleteTask(TaskNode object) throws IllegalArgumentException 
    {
       
        this.TaskList.remove(object);
        
    }
     public void exit() throws IOException {
         boolean flag=false;
         try{
        while(!flag)
        {
        File f=new File(path);
        if(f.exists())
        {
        flag=true;
        FileOutputStream out= new FileOutputStream(path);      
        ObjectOutputStream objectOut = new ObjectOutputStream(out);
        objectOut.writeObject(this);
        out.flush();
        }
        else
        {
            System.out.println("inputfile dosnt exist");
             System.out.println("enter path");
             Scanner s=new Scanner(System.in);
             path=s.nextLine();
        }
        }
         }catch(IOException ioe){
          ioe.printStackTrace();}
    }
      
}
