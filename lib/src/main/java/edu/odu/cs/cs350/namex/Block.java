package edu.odu.cs.cs350.namex;

import java.util.ArrayList;

public class Block {
    String text;
    ArrayList<Token> tokens;

    /**
     * Constructor
     * 
     * @param s the string that will form the Block's text
     */
    public Block(String s) {
        text = s;
    }

    /**
     * Outputs block of text with tags around each personal name
     *
     * @return Returns string with marked up names
     */
    public String outputMarkedNames() {
        StringBuffer markedUpText = new StringBuffer();

        for (Token t : tokens) {
            // if the token is the start of a name, add a tag before adding the name
            if (t.isBeginningOfName()) {
                markedUpText.append("<PER>");
                markedUpText.append(t.getRawToken());
            }
            // if the token is the end of a name, add a tag after adding the name
            else if (t.isEndOfName()) {
                markedUpText.append(t.getRawToken());
                markedUpText.append("</PER>");
            }
            // otherwise, the token is not part of a name, or the continuation of a name, so
            // can be appended by itself
            else {
                markedUpText.append(t.getRawToken());
            }
        }
        return markedUpText.toString();
    }

    /**
     * Separates text into individual tokens for each word in the text
     */
    public void separateIntoTokens() {
        tokens = new ArrayList<>();

        // split the text into its individual words
        // and create Tokens
        for (String word : text.split(" ")) {
            Token t = new Token(word);
            tokens.add(t);
        }

    }

    /**
     * 
     * @return an ArrayList of Tokens, each Token is a word from the block of text
     */
    public ArrayList<Token> getTokens() {
        return tokens;
    }

    /**
     * 
     * @return string that forms the text block
     */
    public String getText() {
        return text;
    }

}
