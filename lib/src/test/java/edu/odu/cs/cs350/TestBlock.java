package edu.odu.cs.cs350;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestBlock {

    @Test
    void testConstructor() {
        fail("Not yet implemented");
    }

    @Test
    void testOutputMarkedNames() {
        Block b = new Block("This is my input string");
        String markedText = b.outputMarkedNames();

        assertTrue(markedText.startsWith("<PER>"));
        assertTrue(markedText.endsWith("</PER>"));
    }

    @Test
    void testSeparateIntoTokens() {
        fail("Not yet implemented");
    }
}