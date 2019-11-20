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
                timer.schedule(new timeTask(), tempCal.getTime());
            }
        }
    }


    private static class timeTask extends TimerTask {
        public void run() {
            System.out.println("Произошла нотификация");
        }
    }

}
