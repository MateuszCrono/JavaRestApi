package com.crud.tasks.service;

import com.crud.tasks.controller.TaskNotFoundException;
import com.crud.tasks.domain.Task;
import com.crud.tasks.repository.TaskRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
class DbServiceTest {

    @InjectMocks
    private DbService dbService;
    @Mock
    private TaskRepository taskRepository;


        @Test
        void saveTask() throws TaskNotFoundException {
            // Given
            Task task1 = new Task(1L, "Task Jedynka", "Pierwszy Task");
            // When
            when(dbService.saveTask(any(Task.class))).thenReturn(task1);
            Task savedTask = dbService.saveTask(task1);
            //Then
            assertEquals("Pierwszy Task", savedTask.getContent());
            assertEquals("Task Jedynka", task1.getTitle());
            //CleanUp
            dbService.deleteTask(task1.getId());
        }

        @Test
        void getAllTasks() throws TaskNotFoundException {
            // Given
            Task task1 = new Task(1L, "First Task", "Content Sample 1");
            Task task2 = new Task(2L, "Second Task", "Content Sample 2");
            Task task3 = new Task(2L, "Third Task", "Content Sample 3");
            List<Task> tasks = new ArrayList<>();
            tasks.add(task1);
            tasks.add(task2);
            tasks.add(task3);
            // When
            when(dbService.getAllTasks()).thenReturn(tasks);
            List<Task> tasksResult = dbService.getAllTasks();
            // Then
            assertEquals(3, tasksResult.size());
            //CleanUp
            dbService.deleteTask(task1.getId());
            dbService.deleteTask(task2.getId());
            dbService.deleteTask(task3.getId());
    }
    @Test
    void getTaskID() throws TaskNotFoundException {
        // Given
        Task task1 = new Task(1L, "Wrong Task", "Content Sample 1");
        Task task2 = new Task(2L, "Searched Task", "Content Sample 2");
        List<Task> tasks = new ArrayList<>();
        tasks.add(task1);
        tasks.add(task2);

        // When
        when(dbService.getAllTasks()).thenReturn(tasks);
        List<Task> tasksResult = dbService.getAllTasks();
        // Then
        assertEquals("Wrong Task", tasksResult.get(0).getTitle());
        assertEquals("Searched Task", tasksResult.get(1).getTitle());
        //CleanUp
        dbService.deleteTask(task1.getId());
        dbService.deleteTask(task2.getId());
    }


}