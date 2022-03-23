package edu.odu.cs.cs350.namex.tools;

public class TagUtil {
    public static String wrapStringByTag(String tag, String string) {
        return String.join("", new String[] {
                "<", tag, ">",
                string,
                "</", tag, ">",
        });
    }
}
