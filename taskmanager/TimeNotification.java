package taskmanager;


import java.io.IOException;
import java.text.ParseException;
import java.util.*;

public class TimeNotification {
    private TaskLog tempLog = new TaskLog();

    public TimeNotification(TaskLog tl) throws IOException, ClassNotFoundException {
        tempLog = tl;
    }

    public TimeNotification() throws IOException, ClassNotFoundException {
    }

    public void onTimeNotification() throws ParseException {
        Timer timer = new Timer();
        for (int i = 0; i < tempLog.getTaskList().size(); i++) {
            GregorianCalendar tempCal = new GregorianCalendar();
            tempCal = tempLog.getTaskList().get(i).getTaskDate();
            tempCal.add(Calendar.MONTH, -1);
            Date tempDate = new Date();
            if (tempCal.getTimeInMillis() > System.currentTimeMillis() && !tempLog.getTaskList().get(i).getChanged()) {
                tempLog.getTaskList().get(i).setChanged(true);
                TimeTask task = new TimeTask(tempLog.getTaskList().get(i));
                timer.schedule(task, tempCal.getTime());
            }
        }
    }

    private class TimeTask extends TimerTask {
        private TaskNode tempNode;

        public TimeTask(TaskNode tempNode) {
            this.tempNode = tempNode;
        }

        public void run() {
            System.out.println("Пришло время: " + tempNode.getTaskName() + "\nНадо сделать: " + tempNode.getTaskDescription());
        }
    }


}
