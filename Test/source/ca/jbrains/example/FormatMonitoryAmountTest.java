package ca.jbrains.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * Created by enricooliva on 16/02/2017.
 */
@RunWith(Parameterized.class)
public class FormatMonitoryAmountTest {

    private final int princeInCents;
    private final String expectedFormatedPrice;

    @Parameterized.Parameters(name = "{0} format to {1}")
    public static Collection<Object[]> data(){
        return Arrays.asList(new Object[][]{
                {789, "$7.89"},
                {520, "$5.20"},
                {400, "$4.00"},
                {0, "$0.00"},
                {2, "$0.02"},
                {2234, "$22.34"}
        });
    }


    public FormatMonitoryAmountTest(int princeInCents, String expectedFormatedPrice) {
        this.princeInCents = princeInCents;
        this.expectedFormatedPrice = expectedFormatedPrice;
    }

    @Test
    public void simplest() throws Exception {
        assertEquals(this.expectedFormatedPrice, format(new Price(this.princeInCents)));
    }

    @Test
    public void test() throws Exception {
        assertEquals(this.expectedFormatedPrice, format(new Price(this.princeInCents)));

        ByteArrayOutputStream canvas =new ByteArrayOutputStream();
        System.setOut(new PrintStream(canvas));

        new ConsoleDisplay().displayPrice(new Price(this.princeInCents));

        Assert.assertEquals(
                Arrays.asList(this.expectedFormatedPrice),
                TextUtilities.lines(canvas.toString("UTF-8")));

    }

    String format(Price price) {
        return String.format("$%,.2f", price.dollarValue());
    }
}
