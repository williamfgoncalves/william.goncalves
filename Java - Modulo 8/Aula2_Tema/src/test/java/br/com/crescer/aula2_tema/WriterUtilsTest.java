package br.com.crescer.aula2_tema;

import br.com.crescer.aula2_tema.WriterUtilsCode;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

/**
 * @author carloshenrique
 */
public class WriterUtilsTest {

    private static final String TARGET_PATH = "target";

    private final WriterUtilsCode writerUtils;

    private String filename;

    public WriterUtilsTest() {
        this.writerUtils = new WriterUtilsCode();
    }

    @Before
    public void setBefore() throws IOException {
        this.filename = TARGET_PATH + "/" + new Date().getTime() + "/testWrite.txt";
        Files.createDirectories(Paths.get(filename).getParent());
    }

    /**
     * Test of write method, of class WriterUtils.
     */
    @Test
    public void testWrite() throws IOException {
        final String test = "teste de inclusão " + new Date().getTime();
        writerUtils.write(filename, test);
        List<String> lines = Files.readAllLines(Paths.get(filename));
        for (String line : lines) {
            System.out.println(line);
        }
        //System.out.println(Files.readAllLines(Paths.get(filename)).toString());
        //assertTrue(Files.readAllLines(Paths.get(filename)).contains(test));
    }
}
