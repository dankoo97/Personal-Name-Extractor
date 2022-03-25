package edu.odu.cs.cs350.namex;

public class Token {
    String rawToken;
    Token nextToken;
    enum TokenClassification {
        NOTNAME,
        STARTOFNAME,
        PARTOFNAME,
        ENDOFNAME,
    }
    FeatureSet features;

    public Token(String str) {
        // Check for white space in string
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

    public String getRawToken() {
        return rawToken;
    }
}
