/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taskmanager;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

/**
 *
 * @author Rodion
 */
public class TaskController {
    private Log tl;
    private final View ui;
TaskController() throws ClassNotFoundException, IOException
{
    this.tl=new TaskLog();
    ui=new View();
}
public Log getLog()
{
    return tl;
}
public void mainView()
{
    this.ui.mainView();
            
}
    public  void createTask() throws IOException, ParseException
    {
        TaskNode newTask=ui.viewForNewTask();
        if(!newTask.getTaskName().isEmpty()&&!newTask.getTaskDescription().isEmpty()&&!newTask.getPhoneNumber().isEmpty())
        {
        tl.createTask(newTask);
        tl.saveAll();
        }
        
    }
    public void deleteTask() throws IOException
    {
        int index=ui.viewForDelete();
        if(tl.size()>index&&index>=0)
        {
            this.tl.deleteTask(tl.get(index));
            tl.saveAll();
        }
        else
            System.out.println("task dosnt exist");
    }
    public void viewAll()
    {
        if(!this.tl.isEmpty())
            ui.viewAllTasks(tl);
            
    }
    public void notification() throws IOException, ClassNotFoundException, ParseException
    {
        new TimeNotification(tl).onTimeNotification();
    }
   public void clear()
   {
       ui.clear();
   }
}
