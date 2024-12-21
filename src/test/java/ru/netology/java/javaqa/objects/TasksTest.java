package ru.netology.java.javaqa.objects;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TasksTest {

    Todos todos = new Todos();

    @Test
    public void shouldFindSimpleTaskByQuery() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");
        Assertions.assertEquals(true, simpleTask.matches("Позвонить"));
    }

    @Test
    public void shouldNotFindSimpleTask() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");
        Assertions.assertEquals(false, simpleTask.matches("Написать"));
    }

    @Test
    public void shouldFindEpicByQuery() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);
        Assertions.assertEquals(true, epic.matches("Молоко"));
    }

    @Test
    public void shouldNotFindEpic() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);
        Assertions.assertEquals(false, epic.matches("Картошка"));
    }

    @Test
    public void shouldFindTopicByQuery() {
        Meetings meeting = new Meetings(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );
        Assertions.assertEquals(true, meeting.matches("приложения"));
    }

    @Test
    public void shouldFindProjectByQuery() {
        Meetings meeting = new Meetings(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );
        Assertions.assertEquals(true, meeting.matches("Приложение"));
    }

    @Test
    public void shouldNotFindMeetingByQuery() {
        Meetings meeting = new Meetings(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );
        Assertions.assertEquals(false, meeting.matches("вторник"));
    }
}