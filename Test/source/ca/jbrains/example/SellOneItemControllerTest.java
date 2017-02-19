package ca.jbrains.example;

import ca.jbrain.exercise.Catalog;
import ca.jbrain.exercise.Display;
import ca.jbrain.exercise.Price;
import ca.jbrain.exercise.SaleController;
import org.jmock.Expectations;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Rule;
import org.junit.Test;

/**
 * Created by enricooliva on 18/02/2017.
 */
public class SellOneItemControllerTest {

    @Rule
    public final JUnitRuleMockery context = new JUnitRuleMockery();

    @Test
    public void productFound() throws Exception {
        final Catalog catalog = context.mock(Catalog.class);
        final Display display = context.mock(Display.class);
        final Price irrilevantPrice = Price.cents(795);

        context.checking(new Expectations(){{
            allowing(catalog).findPrice(with("::product found::"));
            will(returnValue(irrilevantPrice));

            oneOf(display).displayPrice(with(irrilevantPrice));
        }});

        SaleController saleController = new SaleController(display, catalog);
        saleController.onBarcode("::product found::");
    }

    @Test
    public void productNotFound() throws Exception {
        final Display display = context.mock(Display.class);
        final Catalog catalog = context.mock(Catalog.class);

        context.checking(new Expectations(){{
            allowing(catalog).findPrice(with("::product not found::"));
            will(returnValue(null));

            oneOf(display).displayProductNotFound(with("::product not found::"));
        }});

        SaleController saleController = new SaleController(display, catalog);
        saleController.onBarcode("::product not found::");

    }

    @Test
    public void emptyBarcode() throws Exception {
        final Display display = context.mock(Display.class);
        context.checking(new Expectations(){{
            
            oneOf(display).diplayEmptyBarcode();
            
        }});
        SaleController saleController = new SaleController(display, null);
        saleController.onBarcode("");

    }


}
