package edu.odu.cs.cs350;

import java.util.Collection;

public class Block {
    String text;
    Collection<Token> tokens;

    /*
    * Constructor
    */
    public Block(String s) {
        text = s;
    }

    /*
    * Outputs marked names within text
    */
    public String outputMarkedNames() {
        return text;
    }

    /*
    * Separates text into tokens
    */
    public void separateIntoTokens() {

    }
}
