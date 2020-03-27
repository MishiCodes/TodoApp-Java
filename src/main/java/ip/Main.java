package ip;

import java.util.Scanner;

/**
 * This is main class of the project
 *
 * @author Mehwish
 * @version 2020-03-16
 **/


public class Main {
    // A string to hold the data file name which contains all tasks and their details
    public static String filename = "todos.obj";

    /**
     * main method to run the command line based "To Do List" application
     * @param args array of String holding command line parameters
     */
    public static void main(String args[]) {
        // An object of TodoList to hold all tasks and their data
        TodoList todoList = new TodoList();

        //A string to hold the choice that will be entered by the user
        String menuChoice = "-2";

        try {
            Scanner input = new Scanner(System.in);

            // reading the date from task data file
            // if this is the first time, a message will be shown that no data file is found
            todoList.readTodoListFromObjectFile(filename);

            Menu.displayMessage("Welcome to ToDoList", false);

            while (!menuChoice.equals("4")) {
                Menu.showMainMenu(todoList.noOfPendingTodo(), todoList.noOfCompletedTodo());
                menuChoice = input.nextLine();

                switch (menuChoice) {
                    case "1":
                        Menu.showTodoMenuToSort();
                        todoList.displayAllTodosSortedBy(input.nextLine());
                        break;
                    case "2":
                        todoList.getTodoFromUserToAddInTodoList();
                        break;
                    case "3":
                        Menu.editSelectedTodoMessage();
                        todoList.displayAllTodosWithId();
                        todoList.editTodo(input.nextLine());
                        break;
                    case "4":
                        break;

                    default:
                        Menu.commandNotFoundMessage();
                }
            }

            todoList.saveTodoListToObjectFile(filename);
            Menu.exitMessage();

        } catch (Exception e) {
            Menu.displayMessage("UNCAUGHT EXCEPTION THROWN", true);
            System.out.println("Trying to write the unsaved data of all todos in data file");
            todoList.saveTodoListToObjectFile(filename);
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
        }
    }
}
