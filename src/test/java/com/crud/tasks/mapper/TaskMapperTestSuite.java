package com.crud.tasks.mapper;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaskMapperTestSuite {


    private TaskMapper taskMapper = new TaskMapper();


    @Test
    void testTaskMappers() {
        // Given
        Task task1 = new Task(1L, "Task Jedynka", "Pierwszy Task");
        Task task2 = new Task(2L, "Task Dwójeczka", "Drugi Task");
        List<Task> tasks = new ArrayList<>();
        tasks.add(task1);
        tasks.add(task2);
        // When
        TaskDto taskDto = taskMapper.mapToTaskDto(task1);
        Task task = taskMapper.mapToTask(taskDto);
        taskMapper.mapToTaskDtoList(tasks);
        // Then
        assertEquals("Task Jedynka", taskDto.getTitle());
        assertEquals("Pierwszy Task", task.getContent());
        assertEquals(2, taskMapper.mapToTaskDtoList(tasks).size());
    }
}
