package ranking;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author demys
 */
public class StringToVoteTest {

    @Test
    public void cantNull() {
        Vote vote = new StringToVotes().convert("1 2");
        assertNotNull(vote);
    }

    @Test(expected = NumberFormatException.class)
    public void throwsFormatExceptin() {
        new StringToVotes().convert("12 A");
    }

}
