package edu.odu.cs.cs350.namex;

import edu.odu.cs.cs350.namex.tools.TagUtil;
import org.apache.commons.io.FilenameUtils;
import weka.classifiers.functions.SMO;
import weka.core.Instances;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Archivist {

    /** Training data gathered so far */
    private Instances data = null;

    /** The classifier used for machine learning */
    private SMO svm = null;

    public static void main(String[] args) {
        Archivist archivist = new Archivist();
        if (args.length > 0)
        {
            
//          // Creating a function that checks to see if string is a valid file path
//        // Not 100 percent functional
//        public static boolean validFilePath
//        try {
//            path.get(path);
//        } catch (InvalidPathException | NullPointerException ex) {
//            return false;
//        }
//        return true;
//    }
            
//            Try to run a command based on user CLI input using switch statement
//            Possible preliminary commands:
//                shell
//                extract-names (file|string|directory)
//                train (file|string|directory)
//
//            If unable, throw Error
        } else {
//            Open up shell environment
            archivist.shell();
        }
    }

    /**
    * Default constructor for class archivist
    */
    public Archivist() {
//        Load in trained archivist from a default file
    }

    /**
     * Creates an Arff file for training the machine learning algorithm
     * @param k the value of k for shingling
     * @param trainingData data used for training
     * @return arff file
     */
    public static File createARFFWithShingling(int k, String[] trainingData) {
        // TODO: Fix given path
        File output = new File("K" + k + "names.arff.listing");
        InputStream ArffFormat = Archivist.class.getClassLoader().getResourceAsStream("arff_formatting.txt");

        String relation = "";
        ArrayList<String> attributes = new ArrayList<>();
        ArrayList<String> data = new ArrayList<>();

        try {
            Scanner reader = new Scanner(ArffFormat);

            while (reader.hasNext()) {
                String line = reader.nextLine();
                if (line.toLowerCase().startsWith("@relation")) {
                    relation = line;
                } else if (line.toLowerCase().startsWith("@attribute")) {
                    attributes.add(line);
                }
            }

            FileWriter writer = new FileWriter(output);
            writer.write(relation + "\n\n");
            writer.flush();

            writer.write("% Total dimensions = " + ((2 * k + 1) * (attributes.size() - 1) + k + 1) + "\n");
            for (int i = 0; i < 2*k + 1; i++) {
                writer.write("% K = " + (i - k) + "\n");
                for (int j = 0; j < (i <= k ? attributes.size() : attributes.size() - 1); j++) {
                    String writeText = String.join(String.valueOf(i), attributes.get(j).split("\\{num}")) + "\n";
                    writer.write(writeText);
                }
                writer.write("\n");
            }
            writer.flush();

            // TODO: From data create instances to write out to
            writer.write("@data\n");
            for (String s : data) {
                writer.write(s);
                writer.flush();
            }

            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return output;
    }

    /**
     * Creates an Arff file for training the machine learning algorithm
     * @param k the value of k for shingling
     * @param trainingDataFile data used for training
     * @throws IOException in case file not found or unable to be read
     */
    public static File createARFFWithShingling(int k, File trainingDataFile) throws IOException {
        Scanner scanner = new Scanner(trainingDataFile);
        scanner.useDelimiter("(?<=</NER>)[\\s\\S]*?(?=<NER>)");

        List<String> data = new ArrayList<>();

        while (scanner.hasNext()) {
            data.add(scanner.next());
        }

        scanner.close();

        return Archivist.createARFFWithShingling(k, data.toArray(new String[]{}));
    }

    public void shell() {
        boolean cont = true;

        while (cont) {
            System.out.println("Please enter a command. Enter \"help\" for a list of commands");
            Scanner scan = new Scanner(System.in);

            cont = false;
        }
    }

    /**
     * Provides help commands to the user
     * @return manual as a string
     */
    private static String helpCommands() {
//        Extractions
//        Extract from string
//        Extract from file
//        Extract from directory
//
//        Train program
//        Given corrected output, train to match
//
//        Exit shell
        return "";
    }

    /**
    * Attempts to extract personal names from a string s
    */
    public String extract(String s) {
        // TODO: Implement extract string to utilize WEKA library
        return s;
    }

    /**
     * Attempts to extract personal names from a file f and writes the output to a new file at path p
     * without changing the original unless the path p matches f, in which case the file is overwritten.
     * Calls extract(String) for every string wrapped in the proper tags
     * @param readFrom file to read from
     * @param path path to new file
     * @return extracted file
     * @throws IOException unable to read file
     */
    public File extract(File readFrom, Path path) throws IOException {
        // TODO: If file at path already exists should this request confirmation to replace file?
//        Possible files:
//        1. File text without tags
//        2. File is made up of one or more strings properly wrapped by tags
//        3. File is not a readable text file

        // Check that the file can be read from
        if (!readFrom.canRead()) {
            throw new IOException("Unable to read file.");
        }

        // Read from file and build a string
        Scanner reader = new Scanner(readFrom);
        StringBuilder sb = new StringBuilder();
        while (reader.hasNextLine()) {
            sb.append(reader.nextLine());
            sb.append(System.lineSeparator());
        }
        reader.close();
        String contents = sb.toString();

        // Split contents into individual extractable strings
        String regex = "<NER>[\\s\\S]*?</NER>";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(contents);

        // If the file is not properly wrapped by <NER> tags, wrap the entire contents of the text file
        String writeText;
        if (matcher.groupCount() == 0) {
            String results = TagUtil.wrapStringByTag("NER", contents);
            writeText = this.extract(results);
        } else {
            // Extract personal names from each matching group and replace
            StringBuilder results = new StringBuilder();
            while (matcher.find()) {
                String s = matcher.group();
                matcher.appendReplacement(results, this.extract(s));
            }
            matcher.appendTail(results);
            writeText = results.toString();
        }

        // Write to the final path
        File writeTo = path.toFile();
        FileWriter writer = new FileWriter(writeTo);
        writer.write(writeText);
        writer.flush();
        writer.close();

        return writeTo;
    }


    /** Calls extract(f, f.fileBaseName + "_MarkedPersonalNames" + f.fileExtension)
     * @param file file to be extracted
     * @return extracted file
     * @throws IOException unable to read file
     */
    public File extract(File file) throws IOException {
        // Temp fix for file extension
        Path p = Path.of(
                file.getParent() +
                        File.separator +
                        FilenameUtils.getBaseName(file.getAbsolutePath()) +
                        "_MarkedPersonalNames." +
                        FilenameUtils.getExtension(file.getAbsolutePath()));
        return extract(file, p);
    }

    /**
    * Trains archivist using machine learning
    */
    public void trainArchivist(String[] trainingData) {
//        Trains machine learning with a corrected string
    }

    /**
    * Compare a given string to the trained output and
    * return true if they match, else false
    */
    public boolean compareOutput(String s) {
        return false;
    }
    
    /**
    * Archivist manually corrects incorrect output and returns new output
    */
    public String correctOutput(String s)
    {
        String newOutput = ""; // corrected string return variable
        Scanner scan= new Scanner(System.in);
        
        // Ask Archivist to manually correct wrong output string
        System.out.println("Enter the string marked up correctly");
        newOutput=scan.nextLine();
          
        return newOutput;
    }
}
