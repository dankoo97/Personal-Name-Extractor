package edu.odu.cs.cs350;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

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

        assertThat(markedText, markedText.startsWith("<PER>"));
        assertThat(markedText, markedText.endsWith("</PER>"));
    }

    @Test
    void testSeparateIntoTokens() {
        fail("Not yet implemented");
    }
}
