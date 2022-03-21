
//import java.beans.Transient;
import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;

public class TestBlock {

    @Test
    public void TestOutputTextWithMarkedNames() {
        Block b = new Block("This is my input string");
        String markedText = b.outputTextWithMarkedNames();

        assertThat(markedText, startsWith("<PER>"));
        assertThat(markedText, endsWith("</PER>"));
    }
}
