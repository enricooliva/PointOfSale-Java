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

        Catalog catalog = catalogWith("12345", foundPrice);

        Assert.assertEquals(foundPrice,
                catalog.findPrice("12345"));

    }

    @Test
    public void productNotFound() throws Exception {
        Catalog catalog = catalogWithout("12345");
        Assert.assertEquals(null,catalog.findPrice("12345"));
    }

    private Catalog catalogWith(String barcode, Price price) {
        return new InMemoryCatalog(Collections.singletonMap(barcode,price));
    }

    private InMemoryCatalog catalogWithout(String barcode){
        return new InMemoryCatalog(
                Collections.emptyMap());
    }

    public static class InMemoryCatalog implements Catalog {

        private final Map<String, Price> pricesByBarcode;

        public  InMemoryCatalog(Map<String,Price> pricesByBarcode){
            this.pricesByBarcode = pricesByBarcode;
        }

        public Price findPrice(String barcode){
            return pricesByBarcode.get(barcode);
        }

    }


}
