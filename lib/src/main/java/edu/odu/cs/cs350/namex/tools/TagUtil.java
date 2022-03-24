package edu.odu.cs.cs350.namex.tools;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TagUtil {
    /*
    * Wraps a string by the given tag
    */
    public static String wrapStringByTag(String tag, String string) {
        return String.join("", new String[] {
                "<", tag, ">",
                string,
                "</", tag, ">",
        });
    }

    public static String unwrapTags(String string) {
        return "";
    }

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
