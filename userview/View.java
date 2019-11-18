package userview;

import sun.java2d.windows.GDIRenderer;
import taskmanager.TaskLog;
import taskmanager.TaskNode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class View {

    public void viewForNewTask(TaskLog tmp) throws IOException, ParseException {
        Scanner in = new Scanner(System.in);
        TaskNode node = null;
        String taskName;
        String taskDescription;
        GregorianCalendar taskDate = null;
        int yers;
        int month;
        int day;
        int hours;
        int minutes;
        String phoneNumber;
        System.out.println(" | NEW TASK   ");

        System.out.print(" | Событие: ");
        taskName = in.nextLine(); // надо

        System.out.print(" | Описание: ");
        taskDescription = in.nextLine(); // надо
        //проверки на ввод даты?
        System.out.println(" | Год:");
        yers = in.nextInt();
        System.out.println(" | Месяц:");
        month = in.nextInt();
        System.out.println(" | День:");
        day = in.nextInt();
        System.out.println(" | Часы:");
        hours = in.nextInt();
        System.out.println(" | Минуты:");
        minutes = in.nextInt();
        taskDate.set(yers,month,day,hours,minutes);
        node.setTaskDate(taskDate);

        System.out.println(" |Номер телефона: ");
        phoneNumber = in.nextLine();

        node.setTaskName(taskName);
        node.setTaskDescription(taskDescription);
        node.setPhoneNumber(phoneNumber);
        tmp.createTask(node);
        //в файл записать
        tmp.exit();
    }

    public void viewAllTasks(TaskLog tmp) {
        for (int i = 0; i < tmp.getTaskList().size(); i++){
            System.out.println("[i]| TASK |");
            System.out.println("   |Событие: " + tmp.getTaskList().get(i).getTaskName() + ";");
            System.out.println("   |Описание: " + tmp.getTaskList().get(i).getTaskDescription() + ";");
            System.out.println("   |Дата: " + tmp.getTaskList().get(i).getTaskDate() + ";");
            System.out.println("   |Контакты: " + tmp.getTaskList().get(i).getPhoneNumber() + ".");
            System.out.println("   |-------------------------------");

        }
    }
    public void viewForDelete (TaskLog tmp) {
        int number;
        System.out.println(" | Введите что удалить (номер?)");
        Scanner in = new Scanner(System.in);
        number = in.nextInt();
        tmp.deleteTask(tmp.getTaskList().get(number));
    }
}

