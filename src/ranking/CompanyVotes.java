/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ranking;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author demys
 */
public final class CompanyVotes {

    private static final String FAV = "fav";
    private static final String UNFAV = "unfav";
    private static final String NEUTRAL = "neutral";

    private String companyName;

    private List<Vote> votes;

    private int invalidAnswers;

    private Map<Integer, Map<String, Double>> percentStatusById;

    public CompanyVotes(String companyName, List<Vote> votes) {
        this.companyName = companyName;
        percentStatusById = new LinkedHashMap<>();
        this.votes = votes;
        countInvalidAnswers();
        removeInvalidAnswers();
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public List<Vote> getVotes() {
        return votes;
    }

    public void setVotes(List<Vote> votes) {
        this.votes = votes;
    }

    public int getInvalidAnswers() {
        return invalidAnswers;
    }

    public Map<Integer, Map<String, Double>> getPercentStatusById() {
        return percentStatusById;
    }

    public void countInvalidAnswers() {
        votes.forEach(vt -> {
            if (vt.getChoise() < 0 || vt.getChoise() > 4) {
                invalidAnswers++;
            }
        });
    }

    public void removeInvalidAnswers() {
        votes.removeIf(vote -> vote.getChoise() < 0 || vote.getChoise() > 4);
    }

    public void rankingVotes() {
        votes.forEach(vt -> {
            if (!percentStatusById.containsKey(vt.getId())) {
                
            }
        });
    }

}
