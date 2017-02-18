package ca.jbrains.example;

import org.junit.Assert;
import org.junit.Test;

import java.util.Collections;
import java.util.Map;

/**
 * Created by enricooliva on 18/02/2017.
 */
public class FIndPriceInMemoryCatalogTest {
    @Test
    public void productFound() throws Exception {

        Price foundPrice = Price.cents(1250);

        InMemoryCatalog catalog = new InMemoryCatalog(
                Collections.singletonMap("12345", foundPrice));

        Assert.assertEquals(foundPrice,
                catalog.findPrice("12345"));

    }

    public static class InMemoryCatalog{

        private final Map<String, Price> pricesByBarcode;

        public  InMemoryCatalog(Map<String,Price> pricesByBarcode){
            this.pricesByBarcode = pricesByBarcode;
        }

        public Price findPrice(String barcode){
            return pricesByBarcode.get(barcode);
        }

    }


}
