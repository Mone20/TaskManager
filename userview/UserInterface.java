package taskmanager;

import taskmanager.TaskLog;

import java.io.IOException;
import java.io.Serializable;
import java.text.ParseException;
import java.util.Scanner;

/**
 *
 * @author Ilya
 */

public class UserInterface  implements Serializable {
    

    public UserInterface ()  {
       
    }

    public void mainUserInterface() throws IOException, ParseException, ClassNotFoundException {
        System.out.println("TASKMANAGER 0.11");
        Scanner in = new Scanner(System.in);
        boolean exit = false;
        int choice = -1;
        TaskController tc=new TaskController();
        while (!exit){
            
            tc.notification();
            System.out.println("1-Новое событие;");
            System.out.println("2-Просмотр всех событий;");
            System.out.println("3-Удалить событие;");
            System.out.println("0-Закрыто менеджер задач.");
            choice = in.nextInt();
            switch (choice){
                case 1:{
                   tc.createTask(); 
                    //вывод создания нового события
                    break;
                }
                case 2:{
                    tc.viewAll();
                    //вывод всех задач
                    break;
                }
                case 3:{
                    tc.deleteTask();
                    //вывод для удаления
                    break;
                }
                case 0: 
                {
                    tc.getLog().exit();
                    exit = true;
                
                }
            }
        }
    }
}
