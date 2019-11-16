package userview;

import taskmanager.TaskLog;
import java.io.IOException;
import java.util.Scanner;

public class UserInterface {
    TaskLog list;

    public UserInterface () throws IOException, ClassNotFoundException {
        list = new TaskLog();
    }

    public void mainUserInterface(){
        System.out.println("TASKMANAGER 0.1");
        Scanner in = new Scanner(System.in);
        boolean exit = false;
        int choice = -1;
        while (!exit){
            //вывод ближайшего события

            System.out.println("1-Новое событие;");
            System.out.println("2-Просмотр всех событий;"); // будет выводится снизу
            System.out.println("3-Удалить событие;");

            System.out.println("0-Закрыто менеджер задач.");
            choice = in.nextInt();
            switch (choice){
                case 1:{
                    //вывод создания нового события
                    break;
                }
                case 2:{
                    //вывод всех задач
                    break;
                }
                case 3:{
                    //вывод для удаления
                    break;
                }
            }
        }
    }
}
