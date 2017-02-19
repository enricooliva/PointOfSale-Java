package ca.jbrains.example;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by enricooliva on 19/02/2017.
 */
public abstract class FindPriceInCatalogContract {
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

    protected abstract Catalog catalogWith(String barcode, Price price);

    protected abstract Catalog catalogWithout(String barcode);
}
