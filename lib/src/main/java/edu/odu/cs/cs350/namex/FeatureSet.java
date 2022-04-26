package edu.odu.cs.cs350.namex;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//import javax.lang.model.util.ElementScanner14;

public class FeatureSet {
    private Map<String, Integer> featureValues = new HashMap<>(); // mapped collection of features to
                                                                                 // values

    private static Set<String> firstNames = new HashSet<>();
    private static Set<String> lastNames = new HashSet<>();
    private static Set<String> articles = new HashSet<>();
    private static Set<String> killWords = new HashSet<>();
    private static Set<String> honorifics = new HashSet<>();
    private static Set<String> suffixes = new HashSet<>();

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
        featureValues.put("Is Article", articles.contains(word.toUpperCase()) ? 1 : 0);
    }

    /**
     * Determines whether or not the word is a first name and
     * updates the featureValues map with this information
     * 
     * @param word the word to be evaluated
     */
    private void determineIfFirstName(String word) {
        featureValues.put("First Name", firstNames.contains(word.toUpperCase()) ? 1 : 0);
    }

    /**
     * Determines whether or not the word is a last name and
     * updates the featureValues map with this information
     * 
     * @param word the word to be evaluated
     */
    private void determineIfLastName(String word) {
        featureValues.put("Last Name", lastNames.contains(word.toUpperCase()) ? 1 : 0);
    }

    /**
     * Determines whether or not the word is a kill word and
     * updates the featureValues map with this information
     * 
     * @param word the word to be evaluated
     */
    private void determineIfKillWord(String word) {
        featureValues.put("Is Kill Word", killWords.contains(word.toUpperCase()) ? 1 : 0);
    }

    /**
     * Determines whether or not the word is an honorific and
     * updates the featureValues map with this information
     * 
     * @param word the word to be evaluated
     */

    private void determineIfHonorific(String word) {
        featureValues.put("Honorific", honorifics.contains(word.toUpperCase()) ? 1 : 0);
    }

    /**
     * Determines whether or not the word is a suffix and
     * updates the featureValues map with this information
     * 
     * @param word the word to be evaluated
     */
    private void determineIfSuffix(String word) {
        if (suffixes.contains(word)) {
            featureValues.put("Is Suffix", 1);
        } else {
            // Roman Numeral pattern matcher
            // TODO: Test roman numeral patterns
            Pattern pattern = Pattern.compile("(IX{1,3}|X{0,3}(I?V|V?I{0,3}))", Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(word);
            featureValues.put("Is Suffix", matcher.matches() ? 1 : 0);
        }
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
        return featureValues.getOrDefault(feature, -1);
    }

    /**
     * Creates a set of first names from a given file, clears previous contents of firstNames
     * @param fnameFile File to be read from
     * @throws FileNotFoundException first name file is not found
     */
    public static void readNamesFromFirstNameFile(File fnameFile) throws FileNotFoundException {
        Scanner scanner = new Scanner(fnameFile);
        firstNames.clear();

        while (scanner.hasNext()) {
            String name = scanner.nextLine();
            firstNames.add(name.toUpperCase());
        }
    }

    /**
     * Creates a set of last names from a given file, clears previous contents of lastNames
     * @param lnameFile File to be read from
     * @throws FileNotFoundException last name file is not found
     */
    public static void readNamesFromLastNameFile(File lnameFile) throws FileNotFoundException {
        Scanner scanner = new Scanner(lnameFile);
        lastNames.clear();

        while (scanner.hasNext()) {
            String name = scanner.nextLine();
            lastNames.add(name.toUpperCase());
        }
    }

    /**
     * Creates a set of articles from a given file, clears previous contents of articles
     * @param articlesFile File to be read from
     * @throws FileNotFoundException articles file is not found
     */
    public static void readNamesFromArticlesFile(File articlesFile) throws FileNotFoundException {
        Scanner scanner = new Scanner(articlesFile);
        articles.clear();

        while (scanner.hasNext()) {
            String name = scanner.nextLine();
            articles.add(name.toUpperCase());
        }
    }

    /**
     * Creates a set of kill words from a given file, clears previous contents of killWords
     * @param killWordsFile File to be read from
     * @throws FileNotFoundException kill words file is not found
     */
    public static void readNamesFromKillWordsFile(File killWordsFile) throws FileNotFoundException {
        Scanner scanner = new Scanner(killWordsFile);
        killWords.clear();

        while (scanner.hasNext()) {
            String killWord = scanner.nextLine();
            killWords.add(killWord.toUpperCase());
        }
    }

    /**
     * Creates a set of honorifics from a given file, clears previous contents of honorifics
     * @param honorificsFile File to be read from
     * @throws FileNotFoundException honorifics file is not found
     */
    public static void readNamesFromHonorificsFile(File honorificsFile) throws FileNotFoundException {
        Scanner scanner = new Scanner(honorificsFile);
        honorifics.clear();

        while (scanner.hasNext()) {
            String honorific = scanner.nextLine();
            honorifics.add(honorific.toUpperCase());
        }
    }

    /**
     * Creates a set of suffixes from a given file, clears previous contents of suffixes
     * @param suffixesFile File to be read from
     * @throws FileNotFoundException suffix file is not found
     */
    public static void readNamesFromSuffixesFile(File suffixesFile) throws FileNotFoundException {
        Scanner scanner = new Scanner(suffixesFile);
        suffixes.clear();

        while (scanner.hasNext()) {
            String suffix = scanner.nextLine();
            suffixes.add(suffix.toUpperCase());
        }
    }
}
