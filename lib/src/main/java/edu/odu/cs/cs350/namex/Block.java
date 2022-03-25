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
        StringBuffer tempString = new StringBuffer();

        // split the text into individual words called tokens
        for (int i = 0; i < text.length(); i++) {
            // create a token using each word from text and add
            // the token to the ArrayList
            if (text.charAt(i) == ' ') {
                addToken(tempString);
            }
            // if character is not a space, it's part of a token
            else {
                tempString.append(text.charAt(i));

                // add the last token
                if (i == text.length() - 1) {
                    addToken(tempString);
                }
            }

        }

    }

    public ArrayList<Token> getTokens() {
        return tokens;
    }

    private void addToken(StringBuffer sb) {
        // create a Token from the word, add it to
        // the arrayList, and reset the StringBuffer for
        // the next word
        Token t = new Token(sb.toString());
        tokens.add(t);
        sb.delete(0, sb.length());
    }

}
