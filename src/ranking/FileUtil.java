/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ranking;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author demys
 */
public class FileUtil {

    public List<String> readFile(File file) {
        List<String> lines = new ArrayList<>();
        if (file.exists() && file != null) {
            BufferedReader reader = null;
            try {
                reader = new BufferedReader(new FileReader(file));
                while (reader.ready()) {
                    lines.add(reader.readLine());
                }
            } catch (FileNotFoundException ex) {
                lines.add("Not Found File");
                Logger.getLogger(FileUtil.class.getName()).log(Level.SEVERE,
                        null, ex);
            } catch (IOException ex) {
                lines.add("Fail to Read File");
                Logger.getLogger(FileUtil.class.getName()).log(Level.SEVERE,
                        null, ex);
            } finally {
                if (reader != null) {
                    try {
                        reader.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return lines;
    }
}
