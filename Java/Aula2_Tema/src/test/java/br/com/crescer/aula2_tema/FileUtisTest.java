
package br.com.crescer.aula2_tema;

import org.junit.Test;
import static org.junit.Assert.*;

public class FileUtisTest {
    
    public FileUtisTest() {
    }

    @org.junit.Test
    public void testMk() {
        FileUtilsCode ftc = new FileUtilsCode();
        boolean teste = ftc.mk("log/log.txt");
        assertTrue(teste);
    }

    @org.junit.Test
    public void testRm() {
    }

    @org.junit.Test
    public void testLs() {
    }

    @org.junit.Test
    public void testMv() {
    }
}
