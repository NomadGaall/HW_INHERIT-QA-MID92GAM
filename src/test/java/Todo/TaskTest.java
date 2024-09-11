package Todo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TaskTest {

    @Test
    public void simpleTaskMatchesTest() {
        SimpleTask task = new SimpleTask(7, "Позвонить другу");

        boolean actual = task.matches("Позвонить");

        Assertions.assertTrue(actual);
    }

    @Test
    public void simpleTaskNotMatchesTest() {
        SimpleTask task = new SimpleTask(7, "Позвонить домой");

        boolean actual = task.matches("Прийти");

        Assertions.assertFalse(actual);
    }

    @Test
    public void epicMatchesTest() {
        Epic epic  = new Epic(7, new String[]{"Позвонить другу", "Написать домой"});

        boolean actual = epic.matches("Позвонить другу");

        Assertions.assertTrue(actual);
    }

    @Test
    public void epicNotMatchesTest() {
        Epic epic  = new Epic(7, new String[]{"Позвонить другу", "Написать домой"});

        boolean actual = epic.matches("Прийти домой");

        Assertions.assertFalse(actual);
    }

    @Test
    public void meetingTopicMatchesTest() {
        Meeting meeting  = new Meeting(7, "Встреча друзей", "Друзья", "Завтра");

        boolean actual = meeting.matches("Встреча друзей");

        Assertions.assertTrue(actual);
    }

    @Test
    public void meetingProjectMatchesTest() {
        Meeting meeting  = new Meeting(7, "Встреча друзей", "Друзья", "Завтра");

        boolean actual = meeting.matches("Друзья");

        Assertions.assertTrue(actual);
    }

    @Test
    public void meetingNotMatchesTest() {
        Meeting meeting  = new Meeting(7, "Встреча друзей", "Друзья", "Завтра");

        boolean actual = meeting.matches("Вечеринка");

        Assertions.assertFalse(actual);
    }
}