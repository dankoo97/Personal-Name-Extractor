package edu.odu.cs.cs350;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Archivist {
    public static void main(String[] args) {
        Archivist archivist = new Archivist();
        if (args.length > 0)
        {
//            Try to run a command based on user CLI input using switch statement
//            If unable, throw Error
        } else {
//            Open up shell environment
            archivist.shell();
        }
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
}