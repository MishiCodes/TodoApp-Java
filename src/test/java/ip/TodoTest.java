package ip;

import org.junit.Before;
import org.junit.Test;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import static org.junit.Assert.*;

/**
 * This class contains tests
 *
 * @author  Mehwish
 **/


public class TodoTest {
    Todo todo;

    String title ="Test Todo Title";
    String project ="Test Todo Project";
    LocalDate dueDate =LocalDate.parse("2020-03-31");


    /**
     * Execute before executing any Test.
     * Initialize the todo object with valid test parameters.
     * @throws Exception
     */
    @Before
    public void createTodoObject() throws Exception {
        try {
            todo = new Todo(title, project, dueDate);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Validate getTitle() method for parameter
     */
    @Test
    public void testTitle() {
        assertEquals(title,todo.getTitle());
    }

    /**
     * Validate setTitle() method for an empty string
     */
    @Test
    public void testIfTitleEmpty() {
        boolean success=false;

        try {
            todo.setTitle("");
            fail("Thrown a NullPointerException");
        } catch (NullPointerException e) {
            success = true;
        }

        assertEquals(true,success);
    }

    /**
     * Validate the setTitle() method for invalid parameter
     */
    @Test
    public void testEmptyTitle() {
        boolean success=false;

        try {
            todo.setTitle("           ");
            fail("thrown a NullPointerException");
        } catch (NullPointerException e) {
            success = true;
        }

        assertEquals(true,success);
    }

    /**
     * Validate setTitle() method for invalid parameter
     */
    @Test
    public void testIfNullTitle() {
        boolean success=false;

        try {
            todo.setTitle(null);
            fail("thrown a NullPointerException");
        } catch (NullPointerException e) {
            success = true;
        }

        assertEquals(true,success);
    }

    /**
     * Validate the getProject() method for valid parameter
     */
    @Test
    public void testIfProjectValid() {
        assertEquals(project,todo.getProject());
    }

    /**
     * Validate the setProject() method for empty parameter
     */
    @Test
    public void testIfProjectEmpty() {
        todo.setProject("");
        assertEquals("",todo.getProject());
    }

    /**
     * Validate the getDueDate() method
     */
    @Test
    public void testIfDueDateValid() {
        assertEquals(dueDate,todo.getDueDate());
    }

    /**
     * Validate the setDueDate() method for wrong format
     */
    @Test
    public void testIfDueDateHasCorrectFormat() {
        boolean success=false;

        try {
            todo.setDueDate(LocalDate.parse("2020-31-12"));
            fail("thrown a DateTimeParseException");
        } catch (DateTimeParseException e) {
            success = true;
        }

        assertEquals(true,success);
    }

    /**
     * Validate setDueDate() for past due date
     */
    @Test
    public void testIfDueDateHasPassed() {
        boolean success=false;

        try {
            todo.setDueDate(LocalDate.parse("2020-01-17"));
            fail("thrown a DateTimeParseException");
        } catch (DateTimeException e) {
            success = true;
        }

        assertEquals(true,success);
    }
}