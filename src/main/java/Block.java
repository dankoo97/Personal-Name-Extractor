
public class Block {

    private String text;

    public Block() {
        text = "";
    }

    public Block(String t) {
        text = t;
    }

    public String outputTextWithMarkedNames() {
        StringBuffer markedUpText = new StringBuffer("<PER>");
        markedUpText.append(text);
        markedUpText.append("</PER>");

        return markedUpText.toString();
    }
}
