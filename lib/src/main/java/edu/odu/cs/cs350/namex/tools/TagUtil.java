package edu.odu.cs.cs350.namex.tools;

public class TagUtil {
    public static String wrapStringByTag(String tag, String string) {
        return "<" + tag + ">" + string + "</" + tag + ">";
    }
}
