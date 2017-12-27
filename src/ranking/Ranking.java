/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ranking;

import java.io.File;
import java.util.List;

/**
 *
 * @author demys
 */
public class Ranking { 
    
    public static void main(String[] args) {
        File file = new File("files/mybank_zqweSt.txt");
        System.out.println(file);
        List<String> lines = new FileUtil().readFile(file);
        System.out.println(lines.isEmpty());
    }
    
}
