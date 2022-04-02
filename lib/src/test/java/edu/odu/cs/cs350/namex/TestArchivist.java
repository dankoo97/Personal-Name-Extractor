package edu.odu.cs.cs350.namex;

import edu.odu.cs.cs350.namex.tools.TagUtil;
import org.apache.commons.io.FilenameUtils;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

public class TestArchivist {

    @Test
    void testExtractString() {
        fail("Not yet implemented");
    }

    @Test
    void testExtractFile() {
        Archivist archivist = new Archivist();
        try {

            // Create file to read from
            File tempReadFromFile = File.createTempFile("read", ".txt");
            tempReadFromFile.deleteOnExit();

            // Example from requirements definition
            String[] writeText = {
                    "<NER>(UUV) master plan. Bluefin Robotics Corporation and</NER>",
                    String.join(System.lineSeparator(), new String[]{
                            "<NER>Final Report",
                            "Prepared for :",
                            " Dr. David Chris Arney",
                            " US Army Research Office",
                            " Research Triangle Park, NC 27 70 9 - 22 11",
                            " Email : david.arney1@us.army.</NER>"}),
                    "<NER>(WHOI) Department of Applied Ocean Physics and</NER>"
            };

            // Fill the file to read from with data
            FileWriter writer = new FileWriter(tempReadFromFile);
            writer.write(String.join(System.lineSeparator(), writeText));
            writer.flush();

            // Attempt to extract
            File tempWrittenToFile = archivist.extract(tempReadFromFile);
            tempWrittenToFile.deleteOnExit();

            // Read extracted file
            Scanner reader = new Scanner(tempWrittenToFile);
            StringBuilder sb = new StringBuilder();
            while (reader.hasNextLine()) {
                sb.append(reader.nextLine());
                sb.append(System.lineSeparator());
            }
            String result = sb.toString();

            // Compare the paths of the read and write file and make sure they are different
            assertThat(tempWrittenToFile.getAbsolutePath(), not(tempReadFromFile.getAbsolutePath()));

            // Compare the written to file is at the expected path
            assertThat(tempWrittenToFile.getAbsolutePath(), equalTo(
                    tempReadFromFile.getParent() +
                            File.separator +
                            FilenameUtils.getBaseName(tempReadFromFile.getAbsolutePath()) +
                            "_MarkedPersonalNames." +
                            FilenameUtils.getExtension(tempReadFromFile.getAbsolutePath())
                    ));

            // Assert that the written and read files can still be read and written
            assertTrue(tempWrittenToFile.canWrite());
            assertTrue(tempWrittenToFile.canRead());

            assertTrue(tempReadFromFile.canWrite());
            assertTrue(tempReadFromFile.canRead());

            // Assert correctness of results compared to individual calls to extract(String)
            for (String s : writeText) {
                assertThat(result, containsString(archivist.extract(s)));
            }

            // Write a file without <NER> tags
            writeText = new String[]{
                    "I am Dr. Tobias Funke",
                    "I am the world's first analyst and therapist",
                    "The world's first ",
                    "",
            };
            writer = new FileWriter(tempWrittenToFile);
            writer.write(String.join(System.lineSeparator(), writeText));
            writer.flush();

            // Attempt to extract from file
            tempWrittenToFile = archivist.extract(tempWrittenToFile);

            // Read extracted file
            reader = new Scanner(tempWrittenToFile);
            sb = new StringBuilder();
            while (reader.hasNextLine()) {
                sb.append(reader.nextLine());
                sb.append(System.lineSeparator());
            }
            result = sb.toString();

            // Assert that the results match the extracted string
            assertThat(result, equalTo(archivist.extract(
                    TagUtil.wrapStringByTag("NER", String.join(System.lineSeparator(), writeText))) + System.lineSeparator()));

            writer.close();
            reader.close();


        } catch (IOException e) {
            e.printStackTrace();
            fail(e);
        }
    }

    @Test
    void testCreateARFFWithShingling() {
        fail("Not yet implemented");
    }

    @Test
    void testTrainArchivist() {
        fail("Not yet implemented");
    }

    @Test
    void testCompareOutput() {
        Archivist archivist = new Archivist();
        String input = "";
        boolean output = archivist.compareOutput(input);

//        Assert that an extracted string and input string comparison matches output

        fail("Not yet implemented");
    }
    @Test
    void testCorrectOutput()
    {
        Archivist a= new Archivist();
        String input="Dr.<PER>David Chris Arney</PER>";
        String correctedOutput="<PER>Dr. David Chris Arney</PER>";
        // assert corrected output string equals output from correctOutput function
        assertThat(correctedOutput, equalTo(a.correctOutput(input)));
    }
}
