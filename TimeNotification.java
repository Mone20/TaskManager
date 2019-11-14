package taskmanager; 

import java.io.IOException; 
import java.util.Date; 

public class TimeNotification implements TaskInterface { 

@Override 
public void createTask(String name, String description, Date date, String number) { 

} 

@Override 
public void deleteTask(TaskNode object) { 

} 

@Override 
public void exit() throws IOException { 

} 

public void timeNotificating() throws IOException, ClassNotFoundException { 
TaskLog temp = new TaskLog(); 
long minTime = Long.MAX_VALUE; 
Date curr = new Date(); 
for (int i = 0; i < temp.getTaskList().size(); i++) 
if (temp.getTaskList().get(i).getTaskDate().getTime() - curr.getTime() < minTime && curr.after(temp.getTaskList().get(i).getTaskDate())) 
minTime = temp.getTaskList().get(i).getTaskDate().getTime() - curr.getTime(); 
if (minTime<Long.MAX_VALUE) 
System.out.println("Произошла нотификация. "); 

} 
}