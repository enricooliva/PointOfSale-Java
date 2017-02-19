package ca.jbrains.example;

import ca.jbrain.exercise.Catalog;
import ca.jbrain.exercise.InMemoryCatalog;
import ca.jbrain.exercise.Price;

import java.util.Collections;

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


}
