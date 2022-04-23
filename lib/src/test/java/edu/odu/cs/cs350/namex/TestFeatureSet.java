package edu.odu.cs.cs350.namex;

//import org.gradle.internal.impldep.org.junit.Test;

import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import static org.junit.jupiter.api.Assertions.*;

public class TestFeatureSet {

    @Test
    void testDefineFeatures() {
        FeatureSet features = new FeatureSet();
        features.defineFeatures("an");
        Integer number = features.getFeature("Article");

        // assert that "an" is an article
        assertEquals(number, 1);

        // assert that "an" isn't a first name, last name, kill word,
        // honorific, or suffix
        number = features.getFeature("First Name");
        assertEquals(number, 0);

        number = features.getFeature("Last Name");
        assertEquals(number, 0);

        number = features.getFeature("Kill Word");
        assertEquals(number, 0);

        number = features.getFeature("Honorific");
        assertEquals(number, 0);

        number = features.getFeature("Suffix");
        assertEquals(number, 0);
    }
}
