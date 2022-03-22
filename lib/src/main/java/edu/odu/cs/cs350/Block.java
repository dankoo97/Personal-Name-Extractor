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
        StringBuffer markedUpText = new StringBuffer("<PER>");
        markedUpText.append(text);
        markedUpText.append("</PER>");

        return markedUpText.toString();
    }

    /*
     * Separates text into tokens
     */
    public void separateIntoTokens() {

    }
}
