package taskmanager;


import java.io.IOException;
import java.text.ParseException;
import java.util.*;

public class TimeNotification {
    private TaskLog temp;

    public TimeNotification(TaskLog tl) throws IOException, ClassNotFoundException {
        temp=tl;
    }


    public void onTimeNotification() throws ParseException {
        Timer timer = new Timer();
        for (int i = 0; i < temp.getTaskList().size(); i++) {
            GregorianCalendar tempCal = new GregorianCalendar();
            tempCal = temp.getTaskList().get(i).getTaskDate();
            tempCal.add(Calendar.MONTH, -1);
            Date tempDate = new Date();
            if (tempCal.getTimeInMillis() > System.currentTimeMillis() && !temp.getTaskList().get(i).getChanged() ) {
                temp.getTaskList().get(i).setChanged(true);
                timer.schedule(new timeTask(temp.getTaskList().get(i)), tempCal.getTime());
                
            }
        }
    }


    private class timeTask extends TimerTask {
        TaskNode notificationTask;
        timeTask(TaskNode tn)
        {
            this.notificationTask=tn;
        }
        @Override
        public void run() {
            System.out.println("TASK NOTIFICATION");
            System.out.println("НАЗВАНИЕ:"+this.notificationTask.getTaskName());
             System.out.println("ОПИСАНИЕ:"+this.notificationTask.getTaskDescription());
              System.out.println("НОМЕР:"+this.notificationTask.getPhoneNumber());
               
        }
    }

}