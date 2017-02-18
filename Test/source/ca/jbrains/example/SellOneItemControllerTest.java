package ca.jbrains.example;

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
            allowing(catalog).findPrice(with("12345"));
            will(returnValue(irrilevantPrice));

            oneOf(display).displayPrice(with(irrilevantPrice));
        }});

        SaleController saleController = new SaleController(display, catalog);
        saleController.onBarcode("12345");

        //context.assertIsSatisfied();
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

    public interface Catalog{
        Price findPrice (String barcode);
    }

    public interface Display{
        void displayPrice(Price price);
        void displayProductNotFound(String with);

        void diplayEmptyBarcode();
    }

    public static class Price {
        public static Price cents(int centsValue){
            return new Price();
        }

        @Override
        public String toString() {
            return "a Price";
        }
    }

    //controller mediate the communication between display and catalog
    public static class SaleController{
        private Display display;
        private Catalog catalog;

        public SaleController(Display display, Catalog catalog){
            this.display = display;
            this.catalog = catalog;
        }

        public void onBarcode(String barcode){
            if("".equals(barcode)){
                display.diplayEmptyBarcode();
                return;
            }

            Price price = catalog.findPrice(barcode);
            if (price==null)
                display.displayProductNotFound(barcode);
            else
                display.displayPrice(price);
        }
    }

}
