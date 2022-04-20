package edu.odu.cs.cs350.namex.tools;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TagUtil {
    /**
     * Wraps a string with tags
     *
     * @param tag The given tag to wrap the string
     * @param string The string to be wrapped
     * @return The returned string wrapped with the given tags
     */
    public static String wrapStringByTag(String tag, String string) {
        return String.join("", new String[] {
                "<", tag, ">",
                string,
                "</", tag, ">",
        });
    }

    /**
     * Unwraps all tags from a string
     *
     * @param string The given string to remove all tags from
     * @return The given string without tags
     */
    public static String unwrapTags(String string) {
        StringBuilder result = new StringBuilder();

        String regex = "</?[\\s\\S]*?>";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(string);

        while (matcher.find()) {
            matcher.appendReplacement(result, "");
        }
        matcher.appendTail(result);

        return result.toString();
    }

    /**
     * Unwraps all instances of a given tag from a string
     *
     * @param tag The tag to remove
     * @param string The string from which to search and remove the given tag
     * @return The given string without tags
     */
    public static String unwrapTag(String tag, String string) {
        StringBuilder result = new StringBuilder();

        String regex = "</?" + tag + ">";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(string);
        while (matcher.find()) {
            matcher.appendReplacement(result, "");
        }
        matcher.appendTail(result);

        return result.toString();
    }
}
