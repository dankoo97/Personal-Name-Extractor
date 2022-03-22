package edu.odu.cs.cs350;

import java.io.File;
import java.util.Scanner;

class Archivist {
    public static void main(String[] args) {
        Archivist archivist = new Archivist();
        if (args.length > 0)
        {
            
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
    * Attempts to extract personal names from a file f
    */
    public String extract(File f) {
//        Possible options:
//        1. File text without tags
//        2. File is made up of one or more strings properly wrapped by tags
//        3. File is not a readable text file
        return "";
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

   





