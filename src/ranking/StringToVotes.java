/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ranking;

import java.util.logging.Logger;

/**
 *
 * @author demys
 */
public class StringToVotes {

    public Vote convert(String line) {
        String[] cols = line.split(" ");
        if (cols.length == 2) {
            int id = Integer.parseInt(cols[0]);
            int choice = Integer.parseInt(cols[1]);
            return new Vote(id, choice);
        }
        return null;
    }
}
