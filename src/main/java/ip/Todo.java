package ip;

import java.io.Serializable;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * This class consist of a Todo title, project, dueDate, completed status and getters and setters methods

 * @author  Mehwish
 * @version 2020-03-16
 **/


public class Todo implements Serializable {

    private String title;
    private String project;
    private boolean complete;
    private LocalDate dueDate;


    /**
     * Constructor to create object of Todo
     * @param title to hold todo title and it is mandatory field
     * @param project Name of project (can be empty)
     * @param dueDate date according to specified format
     */
    public Todo(String title, String project, LocalDate dueDate) {

        this.setTitle(title);
        this.setProject(project);
        this.complete = false;
        this.setDueDate(dueDate);
    }

    /**
     * To get the title of a todo
     * @return title of a todo
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * Set the title of a Todo object
     * @param title A todo title
     */
    public void setTitle(String title) throws NullPointerException {
        if (title.trim().equals("") || title == null) {
            throw new NullPointerException("REQUIRED: Title can not be empty.");
        }
        this.title = title.trim();
    }

    /**
     * To get the name of the project
     * @return returns the name of the project
     */
    public String getProject() {
        return this.project;
    }

    /**
     * To set the name of the project
     * @param project Name of project, it can be null or empty
     */
    public void setProject(String project) {
        this.project = project.trim();
    }

    /**
     * To get the status of todo as complete or pending
     * @return true is returned in case of completed todo
     */
    public boolean isComplete() {
        return this.complete;
    }

    /**
     * To mark a todo as pending
     * @return the value of todo status as pending
     */
    public boolean markPending() {
        this.complete = false;
        return this.complete;
    }

    /**
     * A method to mark a todo as completed
     * @return the value of the field complete as done
     */
    public boolean markCompleted() {
        this.complete = true;
        return this.complete;
    }

    /**
     * To get the due date of the todo
     * @return the due date of todo as LocalDate object
     */
    public LocalDate getDueDate() {
        return dueDate;
    }

    /**
     * To set the due date of a todo
     * @param dueDate The due date of the todo in specified format
     */
    public void setDueDate(LocalDate dueDate) throws DateTimeException {
        if (dueDate.compareTo(LocalDate.now())<0) {
            throw new DateTimeException("Past Date not allowed");
        }

        DateTimeFormatter formattedDate = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        this.dueDate = LocalDate.parse(dueDate.format(formattedDate));
    }

    /**
     * To get the todo as a formatted string
     * @return formatted string of a todo
     */
    public String formattedTodo() {
        return (
                "\nTitle     : " + title +
                        "\nProject   : " + project +
                        "\nStatus    : " + (complete?"Completed":"NOT COMPLETED") +
                        "\nDue Date  : " + dueDate +
                        "\n");
    }
}


