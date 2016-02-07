package testsuites0702.features;

import org.junit.Test;
import org.junit.experimental.categories.Category;
import testsuites0702.categories.Smoke;

import static testsuites0702.pages.ToDoMVC.*;

@Category(Smoke.class)
public class TodosE2E extends BaseTest {

    @Test
    public void testTasksCommonFlow() {

        givenAtAll();
        add("a");
        assertVisibleTasks("a");
        toggleAll();

        filterActive();
        assertEmptyVisibleTasks();

        add("b");
        toggle("b");
        assertEmptyVisibleTasks();

        filterCompleted();
        assertVisibleTasks("a", "b");

        //activate task
        toggle("a");
        assertVisibleTasks("b");

        сlearCompleted();
        assertEmptyVisibleTasks();
        assertItemsLeft(1);

        filterAll();
        delete("a");
        assertEmptyTasks();
    }
}
