package ca.jbrains.example;

import java.util.Collections;
import java.util.Map;

/**
 * Created by enricooliva on 18/02/2017.
 */
public class FindPriceInMemoryCatalogTest extends FindPriceInCatalogContract {

    @Override
    protected Catalog catalogWith(String barcode, Price price) {
        return new InMemoryCatalog(Collections.singletonMap(barcode,price));
    }

    @Override
    protected InMemoryCatalog catalogWithout(String barcode){
        return new InMemoryCatalog(
                Collections.singletonMap("anything but "+barcode,
                        Price.cents((0))));
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
