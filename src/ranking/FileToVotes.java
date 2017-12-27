/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ranking;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author demys
 */
public class FileToVotes {

    public List<Vote> convertFile(File file) {
        List<String> lines = new FileUtil().readFile(file);
        List<Vote> votes = new ArrayList<>();
        lines.forEach(line -> votes.add(convertLine(line)));
        votes.removeIf(vt -> vt == null);
        return votes;
    }

    public Vote convertLine(String line) {
        String[] cols = line.split(" ");
        if (cols.length == 2) {
            int id = Integer.parseInt(cols[0]);
            int choice = Integer.parseInt(cols[1]);
            return new Vote(id, choice);
        }
        return null;
    }
}
