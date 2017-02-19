package ca.jbrain.exercise;

import java.util.HashMap;

/**
 * Created by enricooliva on 19/02/2017.
 */
public class VirtualPointOfSaleTerminal {
    public static void main(String[] args){

        SaleController saleController = new SaleController(
                new EnglishLanguageConsoleDisplay(),
                new InMemoryCatalog(
                        new HashMap<String,Price>(){{
                            put("12345",new Price(795));
                            put("23456",new Price(12950));
                }}));

        saleController.onBarcode("12345");
        saleController.onBarcode("23456");
        saleController.onBarcode("99999");
        saleController.onBarcode("");
    }
}
