package ip;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

/**
 * This class consist of an ArrayList of Todo class objects
 *
 * @author  Mehwish
 * @version 2020-03-16
 **/

public class TodoList {
    private ArrayList<Todo> todoList;

    /**
     * constructor
     */
    public TodoList() {
        todoList = new ArrayList<>();
    }

    /**
     * Takes values for Todo object from user and add in TodoList array.
     * @return true, if Todo is added successfully to TodoList
     */
    public boolean getTodoFromUserToAddInTodoList() {
        Scanner scan = new Scanner(System.in);

        try {
            System.out.println("Enter the following values for a todo:");
            System.out.println(">>> Todo Title  : ");
            String title = scan.nextLine();
            System.out.println(">>> Project Name: ");
            String project = scan.nextLine();
            System.out.println(">>> Due Date (Format: 2020-03-21) : ");
            LocalDate dueDate = LocalDate.parse(scan.nextLine());

            this.todoList.add(new Todo(title,project,dueDate));
            Menu.displayMessage("Todo has been added successfully", false);

            return true;
        } catch (Exception e) {
            Menu.displayMessage(e.getMessage(),true);
            return false;
        }
    }

    /**
     * Get value from user to edit the selected Todo
     * @param todo the todo object whose value need to be edited with user input
     * @return true, if the Todo is edited
     */
    public boolean getValueFromUserToUpdateTodo(Todo todo) {
        Scanner scan = new Scanner(System.in);
        boolean edited = false;

        try {
            System.out.println("Enter the following values to edit a todo:"
                    + "\nIn case if you do not wish to edit the any of the value, press ENTER key!");
            System.out.println(">>> Task Title  : ");
            String title = scan.nextLine();
            if (!(title.trim().equals("") || title == null)) {
                todo.setTitle(title);
                edited = true;
            }

            System.out.println(">>> Project Name: ");
            String project = scan.nextLine();
            if (!(project.trim().equals("") || project == null)) {
                todo.setProject(project);
                edited = true;
            }

            System.out.println(">>> Due Date (e.g 2020-03-31) : ");
            String dueDate = scan.nextLine();
            if (!(dueDate.trim().equals("") || dueDate == null)) {
                todo.setDueDate(LocalDate.parse(dueDate));
                edited = true;
            }

            Menu.displayMessage("Todo is " + (edited ? "Edited successfully" : "Not modified") , false);

            return true;
        } catch (Exception e) {
            Menu.displayMessage(e.getMessage(), true);
            return false;
        }
    }


    /**
     * A method to Show the number of Completed Todos
     * @return number of Completed Todos
     */
    public int noOfCompletedTodo() {
        return (int) todoList.stream()
                .filter(Todo::isComplete)
                .count();
    }

    /**
     * A method to Show the number of pending Todos
     * @return number of pending Todos
     */
    public int noOfPendingTodo() {
        return (int) todoList.stream()
                .filter(todo -> !todo.isComplete())
                .count();
    }

    /**
     * Display the Todo List with respect to Todo ID
     */
    public void displayAllTodosWithId() {
        String displayFormat = "%-4s %-35s %-20s %-15s %-10s";

        if (todoList.size()>0) {
            System.out.println("");
            System.out.println(String.format(displayFormat,"ID","TITLE","PROJECT","DUE-DATE","COMPLETED"));
            System.out.println(String.format(displayFormat,"--","-----","-------","--------","---------"));
        } else {
            System.out.println("Todo List is empty");
        }

        todoList.stream()
                .forEach(todo -> System.out.println(String.format(displayFormat,
                        todoList.indexOf(todo)+1,
                        todo.getTitle(),
                        todo.getProject(),
                        todo.getDueDate(),
                        (todo.isComplete()?"Yes":"No")
                )));
    }

    /**
     * A method to display the contents of ArrayList
     * @param sortBy in case of string value '2' Todo List is sorted w.r.t project otherwise by date
     */
    public void displayAllTodosSortedBy(String sortBy) {
        System.out.println(
                "Total Todos = " + todoList.size() +
                        "\t\t (Completed = " + noOfCompletedTodo() + "\t\t" +
                        " Pending = " + noOfPendingTodo()+
                        " )");

        if (sortBy.equals("2")) {
            String displayFormat = "%-20s %-35s %-15s %-10s";

            if (todoList.size()>0) {
                System.out.println(String.format(displayFormat,"PROJECT","TITLE","DUE-DATE","COMPLETED"));
                System.out.println(String.format(displayFormat,"-------","-----","--------","---------"));
            } else {
                System.out.println("Todo List is empty");
            }

            todoList.stream()
                    .sorted(Comparator.comparing(Todo::getProject))
                    .forEach(task -> System.out.println(String.format(displayFormat,task.getProject(),
                            task.getTitle(),
                            task.getDueDate(),
                            (task.isComplete()?"Yes":"No")
                    )));
        } else {
            String displayFormat = "%-15s %-35s %-20s %-10s";

            if (todoList.size() > 0) {
                System.out.println(String.format(displayFormat,"DUE-DATE","TITLE","PROJECT" , "COMPLETED"));
                System.out.println(String.format(displayFormat,"--------","-----","-------" , "---------"));
            } else {
                System.out.println("Todo List is empty");
            }

            todoList.stream()
                    .sorted(Comparator.comparing(Todo::getDueDate))
                    .forEach(task -> System.out.println(String.format(displayFormat,task.getDueDate(),
                            task.getTitle(),
                            task.getProject(),
                            (task.isComplete() ? "Yes" : "No")
                    )));
        }
    }

    /**
     * Edit the Todo selected by user based on edit title, mark as completed and remove
     * @param todoToBeEdited Todo Selected by user
     * @throws NullPointerException if Todo ID does not exist
     * @throws ArrayIndexOutOfBoundsException If Todo ID is out of range
     */
    public void editTodo(String todoToBeEdited) throws NullPointerException {
        try {
            if (todoToBeEdited.trim().equals("") || todoToBeEdited == null) {
                throw new NullPointerException("No Todo exists");
            }

            int todoID = Integer.parseInt(todoToBeEdited) - 1;
            if (todoID < 0 || todoID > todoList.size()) {
                throw new ArrayIndexOutOfBoundsException("Todo ID is out of range");
            }

            Todo todo = todoList.get(todoID);

            Menu.displayMessage("Todo ID " + todoToBeEdited + "  is selected:" + todo.formattedTodo(), false);

            Menu.editTodoMenu();
            Scanner scan = new Scanner(System.in);
            String editOption = scan.nextLine();
            switch (editOption) {
                case "1":
                    getValueFromUserToUpdateTodo(todo);
                    break;
                case "2":
                    todo.markCompleted();
                    Menu.displayMessage("Todo ID " + todoToBeEdited + " is marked as Completed", false);
                    break;
                case "3":
                    todo.markPending();
                    Menu.displayMessage("Todo ID " + todoToBeEdited + " is marked as Pending", false);
                    break;
                case "4":
                    todoList.remove(todo);
                    Menu.displayMessage("Todo ID " + todoToBeEdited + " is Deleted", true);
                    break;
                default:
                    Menu.commandNotFoundMessage();
                    Menu.displayMessage("Back to Main Menu", true);
            }
        } catch (Exception e) {
            Menu.displayMessage(e.getMessage(),true);
        }
    }


    /**
     * Read the TodoList from file stored on the disk to continue execution
     * from the same state in which program was terminated.
     * @param fileName file path e.g. "resources/todos.obj"
     * @return true if read successfully
     */
    public boolean readTodoListFromObjectFile(String fileName) {
        boolean status = false;

        try {
            if (!Files.isReadable(Paths.get(fileName))) {
                Menu.displayMessage("The data file, i.e., " + fileName + " does not exists", true);
                return false;
            }

            FileInputStream fileInputStream = new FileInputStream(fileName);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            todoList = (ArrayList<Todo>) objectInputStream.readObject();

            objectInputStream.close();
            fileInputStream.close();
            return true;

        } catch (Exception e) {
            Menu.displayMessage(e.getMessage(),true);
            return false;
        }
    }

    /**
     * Write updated TodoList back to file
     * @param filename file path e.g. "resources/todos.obj"
     * @return true if read successfully
     */
    public boolean saveTodoListToObjectFile(String filename) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(filename);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            objectOutputStream.writeObject(todoList);

            objectOutputStream.close();
            fileOutputStream.close();
            return true;

        } catch (Exception e) {
            Menu.displayMessage(e.getMessage(),true);
            return false;
        }
    }
}

