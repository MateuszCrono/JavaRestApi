package com.crud.tasks.config;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class AdminConfigTest {

    @Autowired
    private AdminConfig adminConfig;

    @Test
    public void TestAdminEmailAddress() {
        // Given
        // When
        String AdminEmail = adminConfig.getAdminMail();
        // Then
        assertEquals("matcrono@sgmail.com", AdminEmail);
    }


}