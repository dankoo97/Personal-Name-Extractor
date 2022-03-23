package edu.odu.cs.cs350.namex.tools;

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
        return "";
    }
}
