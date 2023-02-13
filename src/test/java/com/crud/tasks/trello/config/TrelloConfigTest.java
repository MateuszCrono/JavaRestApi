//package com.crud.tasks.trello.config;
//
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//@SpringBootTest
//public class TrelloConfigTest {
//
//    @Autowired
//    private TrelloConfig trelloConfig;
//
//    @Test
//    void testTrelloConfig() {
//
//        //Given
//
//        //When
//        String trelloApiEndpoint = trelloConfig.getTrelloApiEndpoint();
//        String trelloAppKey = trelloConfig.getTrelloAppKey();
//        String trelloToken = trelloConfig.getTrelloToken();
//        String username = trelloConfig.getTrelloUsername();
//
//        //Then
//        assertEquals("https://api.trello.com/1", trelloApiEndpoint);
//        assertEquals("d5a537b3312242dfe89028c2b64b4b3b", trelloAppKey);
//        assertEquals("ATTA29b2122ca9de30b91a3dd1468143153f26850f3d8f473a68a088a496b3d9108fD7799654", trelloToken);
//        assertEquals("mateuszolszewski25", username);
//    }
//}