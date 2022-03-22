package edu.odu.cs.cs350;

public class Token {
    String rawToken;
    boolean TokenClassification;
    FeatureSet features;

    public Token(String str) {
        rawToken = str;
    }

    /*
     * returns if token is the beginning of name
     */
    public boolean isBeginningOfName() {
        return false; // placeholder
    }

    /*
     * returns if token is the end of a name
     */
    public boolean isEndOfName() {
        return false; // placeholder
    }
}
