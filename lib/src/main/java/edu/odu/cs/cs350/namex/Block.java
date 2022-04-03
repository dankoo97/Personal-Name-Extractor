package edu.odu.cs.cs350.namex;

import java.util.ArrayList;

public class Block {
    String text;
    ArrayList<Token> tokens;

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

    /*
     * Separates text into tokens
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

    public ArrayList<Token> getTokens() {
        return tokens;
    }

    public String getText() {
        return text;
    }

}
