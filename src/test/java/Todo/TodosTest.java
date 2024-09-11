package Todo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TodosTest {

    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(7, "Позвонить другу");

        String[] subtasks = { "Яйца", "Сметана", "Творог" };
        Epic epic = new Epic(77, subtasks);

        Meeting meeting = new Meeting(
                777,
                "Сдать до дедлайна",
                "Приложение Блокнот",
                "Во вторник после ужина"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = { simpleTask, epic, meeting };
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchTest() {
        SimpleTask simpleTask = new SimpleTask(7, "Купить Творог");

        String[] subtasks = { "Яйца", "Сметана", "Творог" };
        Epic epic = new Epic(77, subtasks);

        Meeting meeting = new Meeting(
                777,
                "Сдать до дедлайна",
                "Приложение Блокнот",
                "Во вторник после ужина"
        );

        Todos todos = new Todos();
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic};
        Task[] actual = todos.search("Творог");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchOneTest() {
        SimpleTask simpleTask = new SimpleTask(7, "Купить Творог");

        String[] subtasks = { "Яйца", "Сметана", "Творог" };
        Epic epic = new Epic(77, subtasks);

        Meeting meeting = new Meeting(
                777,
                "Сдать до дедлайна",
                "Приложение Блокнот",
                "Во вторник после ужина"
        );

        Todos todos = new Todos();
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {meeting};
        Task[] actual = todos.search("Сдать");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchZeroTest() {
        SimpleTask simpleTask = new SimpleTask(7, "Купить Творог");

        String[] subtasks = { "Яйца", "Сметана", "Творог" };
        Epic epic = new Epic(77, subtasks);

        Meeting meeting = new Meeting(
                777,
                "Сдать до дедлайна",
                "Приложение Блокнот",
                "Во вторник после ужина"
        );

        Todos todos = new Todos();
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {};
        Task[] actual = todos.search("Написать");
        Assertions.assertArrayEquals(expected, actual);
    }

}