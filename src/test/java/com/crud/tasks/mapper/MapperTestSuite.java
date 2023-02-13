//package com.crud.tasks.mapper;
//
//import com.crud.tasks.domain.*;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertFalse;
//
//class MapperTestSuite {
//
//    @Autowired
//    TrelloMapper trelloMapper;
//
//    @Autowired
//    TaskMapper taskMapper;
//
//
//    @Test
//    void testTrelloMappers() {
//        // Given
//        TrelloListDto trelloListDto1 = new TrelloListDto("1", "TrelloListaJeden", true);
//        TrelloListDto trelloListDto2 = new TrelloListDto("2", "TrelloListaDwa", false);
//        List<TrelloListDto> trelloListDtos = new ArrayList<>();
//        trelloListDtos.add(trelloListDto1);
//        trelloListDtos.add(trelloListDto2);
//        TrelloBoardDto trelloBoardDto = new TrelloBoardDto("1", "TrelloTabilca", trelloListDtos);
//        TrelloCardDto trelloCardDto = new TrelloCardDto("Lista", "Testowa", "First", "1");
//        List<TrelloBoardDto> trelloBoardDtos = new ArrayList<>();
//        trelloBoardDtos.add(trelloBoardDto);
//        // When
//        List<TrelloBoard> trelloBoards = trelloMapper.mapToBoards(trelloBoardDtos);
//        List<TrelloBoardDto> trelloBoardsDto = trelloMapper.mapToBoardsDto(trelloBoards);
//        List<TrelloList> trelloLists = trelloMapper.mapToList(trelloListDtos);
//        List<TrelloListDto> trelloListsDto = trelloMapper.mapToListDto(trelloLists);
//        TrelloCard trelloCards = trelloMapper.mapToCard(trelloCardDto);
//        TrelloCardDto trelloCardsDto = trelloMapper.mapToCardDto(trelloCards);
//        // Then
//        assertEquals(1, trelloBoards.size());
//        assertFalse(trelloBoardsDto.isEmpty());
//        assertEquals(2, trelloLists.size());
//        assertEquals(2, trelloListsDto.size());
//        assertEquals("First", trelloCards.getPos());
//        assertEquals("Lista", trelloCardsDto.getName());
//    }
//
//    @Test
//    void testTaskMappers() {
//        // Given
//        Task task1 = new Task(1L, "Task Jedynka", "Pierwszy Task");
//        Task task2 = new Task(2L, "Task Dwójeczka", "Drugi Task");
//        List<Task> tasks = new ArrayList<>();
//        tasks.add(task1);
//        tasks.add(task2);
//        // When
//        TaskDto taskDto = taskMapper.mapToTaskDto(task1);
//        Task task = taskMapper.mapToTask(taskDto);
//        taskMapper.mapToTaskDtoList(tasks);
//        // Then
//        assertEquals("Task Jedynka", taskDto.getTitle());
//        assertEquals("Pierwszy Task", task.getContent());
//        assertEquals(2, taskMapper.mapToTaskDtoList(tasks).size());
//    }
//
//
//}