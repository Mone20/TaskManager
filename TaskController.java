/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taskmanager;

import java.util.Date;

/**
 *
 * @author Rodion
 */
public class TaskController {
    private TaskLog tl;
TaskController(TaskLog object)
{
    this.tl=object;
}
    public  TaskNode createTask(String name,String description,Date date,String number)
    {
        if(!name.isEmpty()&&!description.isEmpty()&&!number.isEmpty())
        return new TaskNode(name,description,date,number);
        else
        return null;
    }
    public void deleteTask(TaskNode o)
    {
        if(tl.getTaskList().contains(o))
            this.tl.deleteTask(o);
    }
    public boolean viewAll()
    {
        return !this.tl.getTaskList().isEmpty();
            
    }
    public boolean viewTask(TaskNode o)
    {
        return !this.tl.getTaskList().contains(o);
    }
}
