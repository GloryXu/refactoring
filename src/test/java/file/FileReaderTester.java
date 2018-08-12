package file;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class FileReaderTester extends TestCase {

    Reader _input;

    public FileReaderTester(String name) {
        super(name);
    }

    @Override
    protected void setUp() throws Exception {
        try {
            _input = new FileReader("./src/test/java/test.txt");
        } catch (FileNotFoundException e) {
            throw new RuntimeException("unable to open test file");
        }
    }

    @Override
    public void tearDown() throws Exception {
        try {
            _input.close();
        } catch (IOException e) {
            throw new RuntimeException("error on closing test file");
        }
    }

    public void testRead() throws IOException {
        char ch = '&';
        for (int i = 0;i < 4; i++) {
            ch = (char) _input.read();
        }
//        assert ('d' == ch);
        assertEquals('d', ch);
//        assertEquals('m', ch);
    }

    public void testReadAtEnd() throws IOException {
        int ch = -1234;
        for (int i = 0;i<98;i++) {
            ch = _input.read();
        }
        assertEquals(-1, _input.read());
    }

    public static Test suite(){
        TestSuite suite = new TestSuite();
        suite.addTest(new FileReaderTester("testRead"));
        suite.addTest(new FileReaderTester("testReadAtEnd"));
        return suite;
    }

    public static void main(String[] args) {
//        junit.textui.TestRunner.run(suite());
        junit.textui.TestRunner.run(new TestSuite(FileReaderTester.class));
    }

}
