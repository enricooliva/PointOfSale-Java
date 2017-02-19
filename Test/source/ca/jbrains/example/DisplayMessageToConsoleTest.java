package ca.jbrains.example;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

/**
 * Created by enricooliva on 19/02/2017.
 */
public class DisplayMessageToConsoleTest {
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
    public void productNotFoundMessage() throws Exception {
        ByteArrayOutputStream canvas = new ByteArrayOutputStream();
        System.setOut(new PrintStream(canvas));

        new EnglishLanguageConsoleDisplay().displayProductNotFound("912345");

        Assert.assertEquals(
                Arrays.asList("Product not found for 912345"),
                TextUtilities.lines(canvas.toString("UTF-8")));
    }

    @Test
    public void emptyBarcodeMessage() throws Exception {
        ByteArrayOutputStream canvas = new ByteArrayOutputStream();
        System.setOut(new PrintStream(canvas));

        new EnglishLanguageConsoleDisplay().diplayEmptyBarcode();

        Assert.assertEquals(
                Arrays.asList("Scanning error: empty barcode"),
                TextUtilities.lines(canvas.toString("UTF-8")));
    }

    @Test
    public void multipleMessages() throws Exception {
        ByteArrayOutputStream canvas = new ByteArrayOutputStream();
        System.setOut(new PrintStream(canvas));

        EnglishLanguageConsoleDisplay englishLanguageConsoleDisplay = new EnglishLanguageConsoleDisplay();
        englishLanguageConsoleDisplay.displayProductNotFound("123455");
        englishLanguageConsoleDisplay.diplayEmptyBarcode();
        englishLanguageConsoleDisplay.displayProductNotFound("912345");
        englishLanguageConsoleDisplay.diplayEmptyBarcode();

        Assert.assertEquals(
                Arrays.asList(
                        "Product not found for 123455",
                        "Scanning error: empty barcode",
                        "Product not found for 912345",
                        "Scanning error: empty barcode"),
                TextUtilities.lines(canvas.toString("UTF-8")));

    }

}
