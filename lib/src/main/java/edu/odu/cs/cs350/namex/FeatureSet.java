package edu.odu.cs.cs350.namex;

import java.util.Map;
import java.util.HashMap;

import javax.lang.model.util.ElementScanner14;

public class FeatureSet {
    private Map<String, Integer> featureValues = new HashMap<String, Integer>(); // mapped collection of features to
                                                                                 // values

    private String[] firstNames = new String[] { "Elizabeth", "Michael", "Jessica", "John" };
    private String[] lastNames = new String[] { "Smith", "Gomez", "Schmidt", "Jones" };
    private String[] articles = new String[] { "a", "an", "the" };
    private String[] killWords = new String[] { "Institute", "Memorial", "Bridge", "Street", "Department",
            "College", "University" }; // words that would indicate it's not part of a name
    private String[] honorifics = new String[] { "Mr.", "Ms.", "Mrs.", "Dr." };
    private String[] suffixes = new String[] { "Sr.", "Jr.", "I", "II", "III", "IV", "V" };

    public FeatureSet() {

    }

    /**
     * Determines the features of a word, like whether it's a
     * first name, a last name, a part of speech, etc.
     * 
     * @param word the word whose features will be defined
     */
    public void defineFeatures(String word) {
        determineIfArticle(word);
        determineIfFirstName(word);
        determineIfLastName(word);
        determineIfKillWord(word);
        determineIfHonorific(word);
        determineIfSuffix(word);
    }

    /**
     * Determines whether or not the word is an article and
     * updates the featureValues map with this information
     * 
     * @param word the word to be evaluated
     */
    private void determineIfArticle(String word) {
        for (String article : articles) {
            if (article.equalsIgnoreCase(word))
                featureValues.put("Article", 1); // 1 indicates it's an article
        }

        // if it exits the loop and hasn't put a value in map, put in
        // a zero to indicate it's not an article
        if (!featureValues.containsKey("Article"))
            featureValues.put("Article", 0);
    }

    /**
     * Determines whether or not the word is a first name and
     * updates the featureValues map with this information
     * 
     * @param word the word to be evaluated
     */
    private void determineIfFirstName(String word) {
        for (String firstName : firstNames) {
            if (firstName.equalsIgnoreCase(word))
                featureValues.put("First Name", 1);
        }

        if (!featureValues.containsKey("First Name"))
            featureValues.put("First Name", 0);
    }

    /**
     * Determines whether or not the word is a last name and
     * updates the featureValues map with this information
     * 
     * @param word the word to be evaluated
     */
    private void determineIfLastName(String word) {
        for (String lastName : lastNames) {
            if (lastName.equalsIgnoreCase(word))
                featureValues.put("Last Name", 1);
        }

        if (!featureValues.containsKey("Last Name"))
            featureValues.put("Last Name", 0);
    }

    /**
     * Determines whether or not the word is a kill word and
     * updates the featureValues map with this information
     * 
     * @param word the word to be evaluated
     */
    private void determineIfKillWord(String word) {
        for (String killWord : killWords) {
            if (killWord.equalsIgnoreCase(word))
                featureValues.put("Kill Word", 1);
        }

        if (!featureValues.containsKey("Kill Word"))
            featureValues.put("Kill Word", 0);
    }

    /**
     * Determines whether or not the word is an honorific and
     * updates the featureValues map with this information
     * 
     * @param word the word to be evaluated
     */

    private void determineIfHonorific(String word) {
        for (String honorific : honorifics) {
            if (honorific.equalsIgnoreCase(word))
                featureValues.put("Honorific", 1);
        }

        if (!featureValues.containsKey("Honorific"))
            featureValues.put("Honorific", 0);
    }

    /**
     * Determines whether or not the word is a suffix and
     * updates the featureValues map with this information
     * 
     * @param word the word to be evaluated
     */
    private void determineIfSuffix(String word) {
        for (String suffix : suffixes) {
            if (suffix.equalsIgnoreCase(word))
                featureValues.put("Suffix", 1);
        }

        if (!featureValues.containsKey("Suffix"))
            featureValues.put("Suffix", 0);
    }

    /**
     * Returns the value associated with the feature in
     * the map. A 1 indicates it is that that feature;
     * a 0 indicates that it isn't that feature. A -1
     * indicates that the feature isn't in the map
     * 
     * @param feature i.e. Article, Suffix, etc, the feature
     *                that will be searched for in the map
     * 
     * @return the value associated with that feature
     */
    public Integer getFeature(String feature) {
        if (featureValues.containsKey(feature))
            return featureValues.get(feature);
        else
            return -1;
    }

}
