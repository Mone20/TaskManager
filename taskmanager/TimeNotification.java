package taskmanager;


import java.io.IOException;
import java.text.ParseException;
import java.util.*;

public class TimeNotification {
    private Log<TaskNode> temp;
    
    public TimeNotification(Log tl) throws IOException, ClassNotFoundException {
        temp=tl;
    }


    public void onTimeNotification() throws ParseException {
        Timer timer = new Timer();
        for (int i = 0; i < temp.size(); i++) {
            GregorianCalendar tempCal = new GregorianCalendar();
            tempCal = temp.get(i).getTaskDate();
            tempCal.add(Calendar.MONTH, -1);
            Date tempDate = new Date();
            if (tempCal.getTimeInMillis() > System.currentTimeMillis() && !temp.get(i).getChanged() ) {
                temp.get(i).setChanged(true);
                timer.schedule(new timeTask(temp.get(i)), tempCal.getTime());
                
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
            
//            ThreadServerPart serverPart=new ThreadServerPart(Server.clientSocket);
//            serverPart.start();
               
        }
    }

}