package ru.netology.java.javaqa.objects;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TasksTest {

    Todos todos = new Todos();

    @Test
    public void shouldFindSimpleTaskByQuery() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        boolean expected = true;
        boolean actual = simpleTask.matches("Позвонить");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotFindSimpleTask() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        boolean expected = false;
        boolean actual = simpleTask.matches("Написать");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindEpicByQuery() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        boolean expected = true;
        boolean actual = epic.matches("Молоко");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotFindEpic() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        boolean expected = false;
        boolean actual = epic.matches("Картошка");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindTopicByQuery() {
        Meetings meeting = new Meetings(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        boolean expected = true;
        boolean actual = meeting.matches("приложения");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindProjectByQuery() {
        Meetings meeting = new Meetings(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        boolean expected = true;
        boolean actual = meeting.matches("Приложение");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindStartByQuery() {
        Meetings meeting = new Meetings(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        boolean expected = true;
        boolean actual = meeting.matches("вторник");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotFindMeetingByQuery() {
        Meetings meeting = new Meetings(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        boolean expected = false;
        boolean actual = meeting.matches("четверг");

        Assertions.assertEquals(expected, actual);
    }
}