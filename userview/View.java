package userview;

import taskmanager.TaskLog;
import taskmanager.TaskNode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class View {

    public void viewForNewTask(TaskLog tmp) throws IOException, ParseException {
        Scanner in = new Scanner(System.in);
        String taskName;
        String taskDescription;
        Date taskDate = null;
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

        System.out.print(" | Год: ");
        yers = in.nextInt();
        taskDate.setYear(yers);
        System.out.print(" | Месяц: ");
        month = in.nextInt();
        taskDate.setMonth(month);
        System.out.print(" | День: ");
        day = in.nextInt(); //хз с днём нет
        System.out.print(" | Час: ");
        hours = in.nextInt();
        taskDate.setHours(hours);
        System.out.print(" | Минуты: ");
        minutes = in.nextInt();
        taskDate.setMinutes(minutes);
        System.out.print(" | Дата: ");
        //SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //taskDate = sdf.parse(br.readLine());
        System.out.println(taskDate);
        System.out.print(" | Контакт:");
        phoneNumber = in.nextLine();
        tmp.createTask(taskName, taskDescription, taskDate, phoneNumber);
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

