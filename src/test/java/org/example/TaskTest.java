package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TaskTest {

    @Test
    public void simpleTaskTitleMatchTrue () {

        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        boolean expected = true;
        boolean actual = simpleTask.matches("Позвонить родителям");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void simpleTaskTitleMatchFalse () {

        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        boolean expected = false;
        boolean actual = simpleTask.matches("Позвонить сыну");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void TaskFalse () {

        Task task = new Task(5);

        boolean expected = false;
        boolean actual = task.matches("Позвонить родителям");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void simpleTaskGetId () {

        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        int expected = 5;
        int actual = simpleTask.getId();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void epicSubtasksMatchTrue() {

        String[] subtasks = { "Молоко", "Яйца", "Хлеб" };
        Epic epic = new Epic(55, subtasks);

        boolean expected = true;
        boolean actual = epic.matches("Яйца");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void epicSubtasksMatchFalse() {

        String[] subtasks = { "Молоко", "Яйца", "Хлеб" };
        Epic epic = new Epic(55, subtasks);

        boolean expected = false;
        boolean actual = epic.matches("Сыр");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void meetingProjectMatchTrue() {

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        boolean expected = true;
        boolean actual = meeting.matches("Приложение НетоБанка");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void meetingProjectMatchFalse() {

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        boolean expected = false;
        boolean actual = meeting.matches("Проект СуперБанк");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void meetingTopicMatchTrue() {

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        boolean expected = true;
        boolean actual = meeting.matches("Выкатка 3й версии приложения");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void meetingTopicMatchFalse() {

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        boolean expected = false;
        boolean actual = meeting.matches("Выкатка 7й версии приложения");
        Assertions.assertEquals(expected, actual);
    }

}
