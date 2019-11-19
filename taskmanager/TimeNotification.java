package taskmanager; 

import taskinterface.TaskInterface;

import java.io.IOException;
import java.util.Date;
import java.util.GregorianCalendar;

public class TimeNotification implements TaskInterface {

@Override 
public void createTask(String name, String description, Date date, String number) { 

}

@Override
public void deleteTask(taskmanager.TaskNode object) {

} 

@Override 
public void exit() throws IOException { 

} 

public void timeNotificating() throws IOException, ClassNotFoundException { 
taskmanager.TaskLog temp = new taskmanager.TaskLog();
    long minTime = Long.MAX_VALUE;
    GregorianCalendar curr = new GregorianCalendar();
    for (int i = 0; i < temp.getTaskList().size(); i++)
        if (temp.getTaskList().get(i).getTaskDate().getTime().getTime() - curr.getTime().getTime() < minTime && curr.after(temp.getTaskList().get(i).getTaskDate()))
        minTime = temp.getTaskList().get(i).getTaskDate().getTime().getTime() - curr.getTime().getTime();
    if (minTime<Long.MAX_VALUE)
    System.out.println("Произошла нотификация. ");

} 
}