package com.kitchen.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MailTestSuite {
    private Mail mail1;
    private Mail mail2;
    @BeforeEach
    public void init() {
         mail1 = new Mail("user@gmail.com", "Test", "Test");
         mail2 = new Mail("user@gmail.com", "Test", "Test", "Test");
    }
    @Test
    public void shouldCreateObjects() {
        //Given in init()
        //When in init()
        //Then
        assertEquals("user@gmail.com",mail1.getMailTo());
        assertEquals("Test",mail1.getSubject());
        assertEquals("Test",mail2.getMessage());
        assertEquals("Test",mail2.getToCc());
    }
}