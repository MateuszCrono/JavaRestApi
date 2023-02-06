package com.crud.tasks.service;

import com.crud.tasks.controller.TaskNotFoundException;
import com.crud.tasks.domain.Task;
import com.crud.tasks.repository.TaskRepository;
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
    void testService() throws TaskNotFoundException {
        //Given
        Task task1 = new Task(1L, "Task Jedynka", "Pierwszy Task");
        Task task2 = new Task(2L, "Task Dwójeczka", "Drugi Task");
        List<Task> tasks = new ArrayList<>();
        tasks.add(task1);
        tasks.add(task2);
        //When
        long id = task1.getId();
        long id1 = task2.getId();
        when(dbService.saveTask(any(Task.class))).thenReturn(task1);
        when(dbService.getAllTasks()).thenReturn(tasks);
        when(taskRepository.findById(id1)).thenReturn(Optional.of(task1));
        Mockito.doNothing().when(taskRepository).deleteById(any());

        //When
        Task savedTask = dbService.saveTask(task1);
        List<Task> tasksResult = dbService.getAllTasks();
        Task resultTask = dbService.getTaskById(id1);

        //Then
        assertEquals(2, tasksResult.size());
        assertEquals("Pierwszy Task", savedTask.getContent());
        assertEquals("Task Jedynka", resultTask.getTitle());

        //CleanUp
        dbService.deleteTask(id);
        dbService.deleteTask(id1);

    }

}