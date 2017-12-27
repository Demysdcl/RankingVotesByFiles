package ranking;

import java.io.File;
import java.util.List;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author demys
 */
public class FileToVoteTest {

    @Test
    public void cantNull() {
        Vote vote = new StringToVotes().convertLine("1 2");
        assertNotNull(vote);
    }

    @Test(expected = NumberFormatException.class)
    public void throwsFormatExceptin() {
        new StringToVotes().convertLine("12 A");
    }
    
    @Test
    public void testConvertFile() {
        File file = new File("files/mybank_zqweSt.txt");
        List<String> lines = new FileUtil().readFile(file);
        List<Vote> votes = new StringToVotes().convertLines(lines);
        int expected = 10;
        assertEquals(expected, votes.size());
        assertNotNull(votes.get(0));
    }

}
