/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ranking;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
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

    private final List<Vote> votes;

    private int invalidAnswers;

    private final Map<Integer, Integer> totalById;
    private final Map<Integer, Map<String, Integer>> totalStatusById;
    private final Map<Integer, Map<String, Long>> percentStatusById;

    public CompanyVotes(String companyName, List<Vote> votes) {
        this.companyName = companyName;
        this.votes = votes;
        totalStatusById = new LinkedHashMap<>();
        percentStatusById = new LinkedHashMap<>();
        totalById = new LinkedHashMap<>();
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

    public int getInvalidAnswers() {
        return invalidAnswers;
    }

    public int getValidAnswers() {
        return votes.size();
    }

    public Map<Integer, Integer> getTotalById() {
        return totalById;
    }

    public Map<Integer, Map<String, Long>> getPercentStatusById() {
        return percentStatusById;
    }

    public Map<Integer, Map<String, Integer>> getTotalStatusById() {
        return totalStatusById;
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
            fillTotalId(vt);
            fillTotalStatus(vt);
        });
        completePercentMap();
    }

    private void fillTotalId(Vote vt) {
        int key = vt.getId();
        if (!totalById.containsKey(key)) {
            totalById.put(key, 1);
        } else {
            int value = totalById.get(key) + 1;
            totalById.replace(key, value);
        }
    }

    private void fillTotalStatus(Vote vt) {
        int key = vt.getId();
        if (!totalStatusById.containsKey(key)) {
            totalStatusById.put(key, new TreeMap<>());
        }
        String status = getSelectStatus(vt);
        Map<String, Integer> statusMap = totalStatusById.get(key);
        if (statusMap.containsKey(status)) {
            int value = statusMap.get(status) + 1;
            statusMap.replace(status, value);
        } else {
            statusMap.put(status, 1);
        }
    }

    private void completePercentMap() {
        totalStatusById.entrySet().forEach(entry -> {
            convertToPercent(entry.getKey(), FAV);
            convertToPercent(entry.getKey(), NEUTRAL);
            convertToPercent(entry.getKey(), UNFAV);
        });
    }

    private void convertToPercent(Integer keyId, String keyStatus) {

        if (!totalStatusById.get(keyId).containsKey(keyStatus)) {
            totalStatusById.get(keyId).put(keyStatus, 0);
        }

        double value = totalStatusById.get(keyId).get(keyStatus);
        double total = totalById.get(keyId);

        double percent = value / total * 100;

        if (!percentStatusById.containsKey(keyId)) {
            percentStatusById.put(keyId, new TreeMap<>());
        }
        percentStatusById.get(keyId).put(keyStatus, Math.round(percent));
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
