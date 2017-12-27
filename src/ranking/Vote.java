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
public class Vote {
    
    private int id;
    private int choise;
    
    public Vote(int id, int choice) {
        this.id = id;
        this.choise = choice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getChoise() {
        return choise;
    }

    public void setChoise(int choise) {
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
    
    
    
}
