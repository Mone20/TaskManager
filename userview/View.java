package userview;

import taskmanager.TaskLog;
import taskmanager.TaskNode;
import java.io.IOException;
import java.io.Serializable;
import java.text.ParseException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 *
 * @author Ilya
 */

public class View implements Serializable {

    public void viewForNewTask(TaskLog tmp) throws IOException, ParseException {
        Scanner in = new Scanner(System.in);
        String taskName;
        String taskDescription;
        int years;
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

        System.out.print(" |Номер телефона: ");
        phoneNumber = in.nextLine();

        //проверки на ввод даты?
        System.out.println(" | Год:");
        years = in.nextInt();
        System.out.println(" | Месяц:");
        month = in.nextInt();
        System.out.println(" | День:");
        day = in.nextInt();
        System.out.println(" | Часы:");
        hours = in.nextInt();
        System.out.println(" | Минуты:");
        minutes = in.nextInt();



        GregorianCalendar taskDate= new GregorianCalendar(years,month,day,hours,minutes);

        TaskNode node = new TaskNode(taskName,taskDescription,taskDate,phoneNumber);
        tmp.createTask(node);
        //в файл записать
        tmp.exit();
    }

    public void viewAllTasks(TaskLog tmp) {
        for (int i = 0; i < tmp.getTaskList().size(); i++){
            System.out.println( "["+i+"] | TASK |");
            System.out.println("   |Событие: " + tmp.getTaskList().get(i).getTaskName() + ";");
            System.out.println("   |Описание: " + tmp.getTaskList().get(i).getTaskDescription() + ";");
            System.out.println("   |Дата: " + tmp.getTaskList().get(i).getTaskDate().get(Calendar.DAY_OF_MONTH) + "." +
                     tmp.getTaskList().get(i).getTaskDate().get(Calendar.MONTH) +"." + tmp.getTaskList().get(i).getTaskDate().get(Calendar.YEAR) +";");
            System.out.println("   |Время: " + tmp.getTaskList().get(i).getTaskDate().get(Calendar.HOUR)+":"+ tmp.getTaskList().get(i).getTaskDate().get(Calendar.MINUTE) + ";");
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

