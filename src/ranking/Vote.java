/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ranking;

/**
 *
 * @author demys
 */
public class Vote implements Comparable<Vote> {

    private Integer id;
    private Integer choise;

    public Vote(int id, int choice) {
        this.id = id;
        this.choise = choice;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getChoise() {
        return choise;
    }

    public void setChoise(Integer choise) {
        this.choise = choise;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Vote other = (Vote) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public int compareTo(Vote o) {
        return o.getChoise().compareTo(choise);
    }

}
