package org.epam.util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PropertyParserTest {
    @Mock
    PropertyParser propertyParser;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        Mockito.when(propertyParser.getPropertyVariable()).thenReturn("property");
    }

    @Test
    void getPropertyVariable() {
        String property = propertyParser.getPropertyVariable();
        assertEquals("property", property);
    }
}