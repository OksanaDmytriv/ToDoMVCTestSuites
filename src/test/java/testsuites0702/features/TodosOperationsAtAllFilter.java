package testsuites0702.features;

import org.junit.Test;
import org.junit.experimental.categories.Category;
import testsuites0702.categories.Buggy;
import testsuites0702.categories.Smoke;

import static testsuites0702.pages.ToDoMVC.TaskType.ACTIVE;
import static testsuites0702.pages.ToDoMVC.TaskType.COMPLETED;
import static testsuites0702.pages.ToDoMVC.*;

@Category(Smoke.class)
public class TodosOperationsAtAllFilter extends BaseTest {

    @Test
    public void testEditAtAll() {
        givenAtAll(aTask("a", COMPLETED));

        startEditing("a", "a edited").pressEnter();
        assertTasks("a edited");
        assertItemsLeft(0);
    }

    @Test
    @Category(Buggy.class)
    public void testCancelEditAtAll() {
        givenAtAll(aTask("a", COMPLETED));

        startEditing("a", "a edited").pressEscape();
        assertTasks("a");
        assertItemsLeft(1);
    }

    @Test
    public void testEditAndClickOutsideAtAll() {
        givenAtAll("a", "b");

        startEditing("a", "a edited");
        newTask.click();
        assertTasks("a edited", "b");
        assertItemsLeft(2);
    }

    @Test
    public void testCompleteAtAll() {
        givenAtAll(aTask("a", ACTIVE),
                aTask("b", COMPLETED));

        assertItemsLeft(1);
        toggle("a");
        assertItemsLeft(0);
    }

    @Test
    public void testClearCompletedAtAll() {
        givenAtAll(aTask("a", COMPLETED),
                aTask("b", COMPLETED));

        assertItemsLeft(0);
        сlearCompleted();
        assertEmptyVisibleTasks();
    }

    @Test
    public void testActivateAllAtAll() {
        givenAtAll(aTask("a", COMPLETED));

        assertItemsLeft(0);
        toggle("a");
        assertItemsLeft(1);
    }

    @Test
    public void testActivateTasksAtAll() {
        givenAtAll(aTask("a", COMPLETED),
                aTask("b", COMPLETED));

        assertItemsLeft(0);
        toggleAll();
        assertItemsLeft(2);
    }

}
