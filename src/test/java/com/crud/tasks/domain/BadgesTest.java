package com.crud.tasks.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BadgesTest {

    @Test
    void testBadges() {
        //Given
        Trello trello = new Trello();
        AttachmentsByType attachmentsByType = new AttachmentsByType();
        attachmentsByType.setTrello(trello);
        Badges badges = new Badges();
        badges.setVotes(1);
        badges.setAttachmentsByType(attachmentsByType);

        //When
        AttachmentsByType result = badges.getAttachmentsByType();
        Trello resultTrello = badges.getAttachmentsByType().getTrello();
        int resultVotes = badges.getVotes();

        //Then
        assertEquals(attachmentsByType, result);
        assertEquals(trello, resultTrello);
        assertEquals(1, resultVotes);
    }
}