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
        b.separateIntoTokens();
        String markedText = b.outputMarkedNames();

        // haven't implemented FeatureSet yet, so outputMarkedNames shouldn't
        fail("Not yet implemented");
        // have any tags yet
        assertThat(markedText, not(containsString("<PER>")));
        assertThat(markedText, not(containsString("</PER>")));
    }

    @Test
    void testSeparateIntoTokens() {
        fail("Not yet implemented");
    }
}
