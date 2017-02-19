package ca.jbrains.example;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by enricooliva on 19/02/2017.
 */
public class LearnHowToHijackSystemOutTest {
    private PrintStream productionSystemOut;

    @Before
    public void rememebrSystemOut() throws Exception {
        productionSystemOut = System.out;
    }

    @After
    public void restoreSystemOut() throws Exception {
        System.setOut(productionSystemOut);
    }

    @Test
    public void singleLineOfText() throws Exception {

        ByteArrayOutputStream canvas =new ByteArrayOutputStream();
        System.setOut(new PrintStream(canvas));

        System.out.println("Hello, workd.");

        Assert.assertEquals(
                Collections.singletonList("Hello, workd."),
                TextUtilities.lines(canvas.toString("UTF-8")));
    }

    @Test
    public void severalLinesOfText() throws Exception {
        ByteArrayOutputStream canvas =new ByteArrayOutputStream();
        System.setOut(new PrintStream(canvas));

        for (int i = 1; i <5; i++) {
            System.out.println("Line "+i);
        }

        Assert.assertEquals(
                Arrays.asList("Line 1","Line 2","Line 3","Line 4"),
                TextUtilities.lines(canvas.toString("UTF-8")));
    }

}
