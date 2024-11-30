package com.touragency;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GuideTest {
    @Test
    public void testGuideDetails() {
        Guide guide = new Guide("Alice", "English");
        assertEquals("Alice", guide.getName());
        assertEquals("English", guide.getLanguage());
    }
}
