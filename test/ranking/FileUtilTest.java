package ranking;


import java.io.File;
import java.util.List;
import static org.junit.Assert.*;
import org.junit.Test;
import ranking.FileUtil;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author demys
 */
public class FileUtilTest {
    
    @Test
    public void testHasItens() {
        File file = new File("files/mybank_zqweSt.txt");
        List<String> lines = new FileUtil().readFile(file);
        assertFalse(lines.isEmpty());
        int expected = 11;
        assertEquals(expected, lines.size());
    }
    
}
