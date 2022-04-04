package edu.odu.cs.cs350.namex;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

public class TestBlock {

    @Test
    void testConstructor() {
        Block b = new Block("testing 1 2 3");
        String testString = b.getText();
        assertEquals(testString, "testing 1 2 3");
    }

    @Test
    void testOutputMarkedNames() {
        Block b = new Block("This is my input string");
        b.separateIntoTokens();
        String markedText = b.outputMarkedNames();

        // haven't implemented FeatureSet yet, so outputMarkedNames shouldn't
        // have any tags yet
        assertThat(markedText, not(containsString("<PER>")));
        assertThat(markedText, not(containsString("</PER>")));
    }

    @Test
    void testSeparateIntoTokens() {
        Block b = new Block("The cow goes moo.");
        b.separateIntoTokens();
        ArrayList<Token> tempTokens = b.getTokens();
        ArrayList<String> s = new ArrayList<>();
        s.add("The");
        s.add("cow");
        s.add("goes");
        s.add("moo.");

        for (int i = 0; i < tempTokens.size(); i++) {
            assertEquals(tempTokens.get(i).getRawToken(), s.get(i));
        }

    }
}
