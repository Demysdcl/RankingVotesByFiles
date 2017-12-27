/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ranking;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author demys
 */
public final class CompanyVotes {

    public static final String FAV = "fav";
    public static final String UNFAV = "unfav";
    public static final String NEUTRAL = "neutral";

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
        rankingVotes();
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
            int key = vt.getId();
            if (!percentStatusById.containsKey(key)) {
                percentStatusById.put(key, new TreeMap<>());
            }
            String status = getSelectStatus(vt);
            Map<String, Double> statusMap = percentStatusById.get(key);
            if (statusMap.containsKey(status)) {
                double value = statusMap.get(status) + 1;
                statusMap.replace(status, value);
            } else {
                statusMap.put(status, 1d);
            }
        });
    }

    public String getSelectStatus(Vote vt) {
        if (vt.getChoise() < 2) {
            return FAV;
        } else if (vt.getChoise() == 2) {
            return NEUTRAL;
        } else {
            return UNFAV;
        }
    }
}
