/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ranking;

import java.io.File;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author demys
 */
public class CompanyVotesTest {

    @Test
    public void testSelectStatus() {
        CompanyVotes companyVotes = new CompanyVotes("My Bank", getVotes());
        Vote vote1 = companyVotes.getVotes().get(1);
        Vote vote2 = companyVotes.getVotes().get(4);
        Vote vote3 = companyVotes.getVotes().get(2);
        assertEquals(CompanyVotes.FAV, companyVotes.getSelectStatus(vote1));
        assertEquals(CompanyVotes.NEUTRAL, companyVotes.getSelectStatus(vote2));
        assertEquals(CompanyVotes.UNFAV, companyVotes.getSelectStatus(vote3));
    }

    @Test
    public void testRemoveInvalidAnswers() {
        CompanyVotes companyVotes = new CompanyVotes("My Bank", getVotes());
        int expected = 9;
        assertEquals(expected, companyVotes.getVotes().size());
    }

    @Test
    public void testCountInvalidAnswers() {
        CompanyVotes companyVotes = new CompanyVotes("My Bank", getVotes());
        int expected = 1;
        assertEquals(expected, companyVotes.getInvalidAnswers());
    }

    private List<Vote> getVotes() {
        return new FileToVotes().convertFile(new File("files/mybank_zqweSt.txt"));
    }

}
