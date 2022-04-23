package edu.odu.cs.cs350.namex;

public class Token {
    private String rawToken;
    private Token nextToken;
    private Token previousToken;

    private enum TokenClassification {
        NOTNAME,
        STARTOFNAME,
        PARTOFNAME,
        ENDOFNAME,
    }

    private TokenClassification classification;
    private FeatureSet features;

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
        return (classification == TokenClassification.STARTOFNAME);
    }

    /**
     * Determines if the token represents the end
     * of a name
     * 
     * @return if token is the end of a name or not
     */
    public boolean isEndOfName() {
        return (classification == TokenClassification.ENDOFNAME);
    }

    /**
     * Determines if the token represents a part of the name,
     * as in a continuation
     * 
     * @return if token is part of a name
     */
    public boolean isPartOfName() {
        return (classification == TokenClassification.PARTOFNAME);
    }

    /**
     * Determines if the token does not represent a name
     * 
     * @return if token isn't a name
     */
    public boolean isNotAName() {
        return (classification == TokenClassification.NOTNAME);
    }

    /**
     * Examines the token's features and classifies it as either
     * not a name, the start of a name, part (or continuation)
     * of name, and end of a name
     */
    public void classifyToken() {

        features.defineFeatures(rawToken);
    }

    /**
     * Returns the word that forms the token
     * 
     * @return the word the Token consists of
     */
    public String getRawToken() {
        return rawToken;
    }

    /**
     * Sets the token that comes before the current
     * token
     * 
     * @param t the token that comes before
     */
    public void setPreviousToken(Token t) {
        previousToken = t;
    }

    /**
     * Sets the token that comes after the current token
     * 
     * @param t the token that comes after
     */
    public void setNextToken(Token t) {
        nextToken = t;
    }
}
