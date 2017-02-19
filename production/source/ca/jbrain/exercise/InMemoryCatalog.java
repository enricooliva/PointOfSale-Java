package ca.jbrain.exercise;

import java.util.Map;

/**
 * Created by enricooliva on 19/02/2017.
 */
public class InMemoryCatalog implements Catalog {

    private final Map<String, Price> pricesByBarcode;

    public InMemoryCatalog(Map<String, Price> pricesByBarcode) {
        this.pricesByBarcode = pricesByBarcode;
    }

    public Price findPrice(String barcode) {
        return pricesByBarcode.get(barcode);
    }

}
