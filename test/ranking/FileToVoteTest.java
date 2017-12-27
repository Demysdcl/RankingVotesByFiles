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
        Vote vote = new FileToVotes().convertLine("1 2");
        assertNotNull(vote);
    }

    @Test(expected = NumberFormatException.class)
    public void throwsFormatExceptin() {
        new FileToVotes().convertLine("12 A");
    }
    
    @Test
    public void testConvertFile() {
        File file = new File("files/mybank_zqweSt.txt");
        List<Vote> votes = new FileToVotes().convertFile(file);
        int expected = 10;
        assertEquals(expected, votes.size());
        assertNotNull(votes.get(0));
    }

}
