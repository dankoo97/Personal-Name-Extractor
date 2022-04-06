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

    /**
     * Constructor
     * 
     * @param str the string that will form the raw token
     */
    public Token(String str) {
        // Check for white space in string
        rawToken = str;
    }

    /**
     * Determines if the token represents the
     * beginning of a name
     * 
     * @return if token is the beginning of a
     *         name or not
     */
    public boolean isBeginningOfName() {
        return false; // placeholder
    }

    /**
     * Determines if the token represents the end
     * of a name
     * 
     * @return if token is the end of a name or not
     */
    public boolean isEndOfName() {
        return false; // placeholder
    }

    /**
     * Returns the word that forms the token
     * 
     * @return the word the Token consists of
     */
    public String getRawToken() {
        return rawToken;
    }
}
