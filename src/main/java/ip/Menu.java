package ip;

/**
 * This class consist of all Messages to be displayed on screen
 *
 * @author  Mehwish
 * @version 2020-03-16
 **/

public class Menu {

    /**
     * Displays the application's main menu
     * @param noOfPendingTodos number of pending todos
     * @param noOfCompletedTodos number of complete todos
     */
    public static void showMainMenu(int noOfPendingTodos, int noOfCompletedTodos) {
        System.out.println("\n\nWelcome to TodoList");
        System.out.println("\nTODO APPLICATION'S MAIN MENU");
        System.out.println("----------------------------\n");
        System.out.println("You have "
                + noOfPendingTodos + " pending todo(s)"
                + " and " + noOfCompletedTodos + " completed todo(s)\n");
        System.out.println(">> Pick an option:");
        System.out.println(">> (1) Show Todo List (by date or project)");
        System.out.println(">> (2) Add New Todo");
        System.out.println(">> (3) Edit Todo (update, mark as done, mark as pending, remove)");
        System.out.println(">> (4) Save and Quit\n");
        System.out.println(">> Please enter your choice [1-4]: ");
    }

    /**
     * Display the given message on screen
     * @param message a text message as String
     * @param warning a boolean value, true or false
     */
    public static void displayMessage(String message, boolean warning) {
        System.out.println(">>> " + message);
    }

    /**
     * Display the options for displaying todos based on sorting selected by user
     */
    public static void showTodoMenuToSort() {
        System.out.println("\nDISPLAY MENU FOR ALL TODOS");
        System.out.println("--------------------------\n");
        System.out.println(">> Pick an option:");
        System.out.println(">> (1) Display Todo List sorted by date");
        System.out.println(">> (2) Display Todo List sorted by project");
        System.out.println("\n>> Please enter your choice [1-2]: ");
    }

    /**
     * Ask the user for entering the todo ID to be edited
     */
    public static void editSelectedTodoMessage() {
        System.out.print(">>> Type a Todo ID to be EDITED and press ENTER key: \n");
    }

    /**
     * Display Edit options for selected Todo
     */
    public static void editTodoMenu() {
        System.out.println("\nEDIT MENU FOR TODOS");
        System.out.println("-------------------\n");
        System.out.println(">> Pick an option:");
        System.out.println(">> (1) Modify selected todo");
        System.out.println(">> (2) Mark selected todo as Completed");
        System.out.println(">> (3) Mark selected todo as Pending");
        System.out.println(">> (4) Delete selected todo");
        System.out.println(">> (5) Display main menu");
        System.out.println("\n>> Please enter your choice [1-4]: ");
    }

    /**
     * This method will display the greeting message before stopping the application.
     */
    public static void exitMessage() {
        System.out.println(">> Todos are saved successfully");
        System.out.println(">> Welcome next time, Bye");
    }

    /**
     * Notify user in case of wrong input
     */
    public static void commandNotFoundMessage() {
        System.out.println(">>> Command not found. Please enter a choice from given options ");
    }
}
