package com.company.taskmanager;

import com.company.*;
import com.company.taskinterface.TaskInterface;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class TimeNotification  {
    private TaskLog temp =new TaskLog();

    public TimeNotification() throws IOException, ClassNotFoundException {
    }


    public void onTimeNotification() throws ParseException {
        Timer timer = new Timer();
        for (int i = 0; i < temp.getTaskList().size(); i++) {
            GregorianCalendar tempCal = new GregorianCalendar();
            tempCal = temp.getTaskList().get(i).getTaskDate();
            tempCal.add(Calendar.MONTH, -1);
            Date tempDate = new Date();
            if (tempCal.getTimeInMillis()>System.currentTimeMillis()) {
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
