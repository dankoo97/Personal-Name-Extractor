package edu.odu.cs.cs350.namex.tools;

import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.junit.jupiter.api.Assertions.fail;

public class TestTagUtil {
    @Test
    void testWrapStringByTag() {
        String string = "I am a string.";
        String tag = "NER";
        String wrapped = TagUtil.wrapStringByTag(tag, string);

        // Assert that a basic string is wrapped
        assertThat(wrapped, is("<NER>I am a string.</NER>"));

        // Assert that a string that contains tags is correctly wrapped
        string = "During the meeting, <PER>James Holden</PER> gave a shocking testimony.";
        tag = "NER";
        wrapped = TagUtil.wrapStringByTag(tag, string);

        assertThat(wrapped, is("<NER>During the meeting, <PER>James Holden</PER> gave a shocking testimony.</NER>"));
    }

    @Test
    void testUnwrapTags() {
        fail("Not yet implemented");
    }

    @Test
    void testUnwrapTag() {
        String string = "<NER>I am a string.</NER>";
        String tag = "NER";
        String unwrapped = TagUtil.unwrapTag(tag, string);
        assertThat(
                "A simple string with one tag that is removed",
                unwrapped,
                is("I am a string."));


        string = "<NER>During the meeting, <PER>James Holden</PER> gave a shocking testimony.</NER>";
        tag = "PER";
        unwrapped = TagUtil.unwrapTag(tag, string);
        assertThat(
                "A string with multiple tags only removes the ones specified",
                unwrapped,
                is("<NER>During the meeting, James Holden gave a shocking testimony.</NER>"));


        string = "<NER><PER>Capt. Raymond Holt</PER> gave a speech to the cadets followed by <PER>Sgt. Amy Peralta</PER></NER>";
        tag = "PER";
        unwrapped = TagUtil.unwrapTag(tag, string);
        assertThat(
                "If multiple of the same tag exist all are removed",
                unwrapped,
                is("<NER>Capt. Raymond Holt gave a speech to the cadets followed by Sgt. Amy Peralta</NER>"));


        string = "<NER><PER>Capt. Raymond Holt</PER> gave a speech to the cadets followed by <PER>Sgt. Amy Peralta</PER></NER>";
        tag = "DNE";
        unwrapped = TagUtil.unwrapTag(tag, string);
        assertThat(
                "If the tag does not exist in the string, then the string is returned asis",
                unwrapped,
                is(string));
    }
}
