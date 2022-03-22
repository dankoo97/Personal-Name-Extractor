package edu.odu.cs.cs350;

public class Block {
    String text;
    Token[] tokens;

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
                markedUpText.append(t);
            }
            // if the token is the end of a name, add a tag after adding the name
            else if (t.isEndOfName()) {
                markedUpText.append(t);
                markedUpText.append("</PER>");
            }
            // otherwise, the token is not part of a name, or the continuation of a name, so
            // can be appended by itself
            else {
                markedUpText.append(t);
            }
        }
        return markedUpText.toString();
    }

    /*
     * Separates text into tokens
     */
    public void separateIntoTokens() {
        // fake data to test Block and Token
        tokens = new Token[2];
        tokens[0] = new Token("fake test data");
        tokens[1] = new Token("more fake tests");
    }
}
