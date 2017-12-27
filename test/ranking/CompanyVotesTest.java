/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ranking;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author demys
 */
public class CompanyVotesTest {

    @Test
    public void testRemoveInvalidAnswers() {
        CompanyVotes companyVotes = new CompanyVotes("My Bank", getVotes());
        int expected = 4;
        assertEquals(expected, companyVotes.getVotes().size());
    }

    @Test
    public void testCountInvalidAnswers() {
        CompanyVotes companyVotes = new CompanyVotes("My Bank", getVotes());
        int expected = 2;
        assertEquals(expected, companyVotes.getInvalidAnswers());
    }

    private List<Vote> getVotes() {
        List<Vote> votes = new ArrayList<>();
        votes.add(new Vote(1, 0));
        votes.add(new Vote(2, 0));
        votes.add(new Vote(3, 0));
        votes.add(new Vote(4, 0));
        votes.add(new Vote(1, 5));
        votes.add(new Vote(2, -1));
        return votes;
    }

}
