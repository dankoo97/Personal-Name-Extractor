package edu.odu.cs.cs350;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Archivist {
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

    /*
    * Default constructor for class archivist
    */
    public Archivist() {
//        Load in trained archivist
    }

    public void shell() {
        boolean cont = true;

        while (cont) {
            System.out.println("Please enter a command. Enter \"help\" for a list of commands");
            Scanner scan = new Scanner(System.in);

            cont = false;
        }
    }

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

    /*
    * Attempts to extract personal names from a string s
    */
    public String extract(String s) {
        return s;
    }

    /*
    * Attempts to extract personal names from a file f and writes the output to a new file at path p
    * without changing the original unless the path p matches f, in which case the file is overwritten
    */
    public File extract(File readFrom, Path path) throws IOException {
//        Possible options:
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
            sb.append("\n");
        }
        reader.close();
        String contents = sb.toString();

        // Split contents into individual extractable strings
        String regex = "<NER>.*?</NER>";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(contents);

        // Extract personal names from each matching group and replace
        StringBuilder results = new StringBuilder(contents);
        while (matcher.find()) {
            String s = matcher.group();
            matcher.appendReplacement(results, extract(s));
        }
        String writeText = results.toString();

        // Write to the final path
        File writeTo = path.toFile();
        FileWriter writer = new FileWriter(writeTo);
        writer.write(writeText);
        writer.flush();
        writer.close();

        return writeTo;
    }

    /*
    * Calls extract(f, f.fileName + "_MarkedPersonalNames" + f.fileExtension)
    */
    public File extract(File f) throws IOException {
        // Temp fix for file extension
        Path p = Path.of(f.getParent() + File.separator + f.getName() + "_MarkedPersonalNames.txt");
        return extract(f, p);
    }

    /*
    * Trains archivist using machine learning
    */
    public void trainArchivist(String s) {
//        Trains machine learning with a corrected string
    }

    /*
    * Compare a given string to the trained output and
    * return true if they match, else false
    */
    public boolean compareOutput(String s) {
        return false;
    }
    
    /*
    * Archivist manually corrects incorrect output and returns new output
    */
    public String correctOutput(String s)
    {
        String newOutput = ""; // corrected string return variable
        // get the original string before marked up (so without the <NER> and </NER>)
        String strNotMarked=" ";
        String[] first=s.split("<NER>"); // string without <NER>
        for(String str:first)
            strNotMarked=str;
        String[] second=strNotMarked.split("</NER>"); // split </NER> from string without <NER>
        for(String str:second)
            strNotMarked=str;
        
        // Mark it up again, but with <NER> and </NER> in the right places
        
        // check if the corrected output matches the original/incorrect output
        // so it doesn't return the same string
        if(compareOutput(newOutput)==true)
        {
            // if the strings are the same, correct it again
        }
        return newOutput;
    }
}

   





