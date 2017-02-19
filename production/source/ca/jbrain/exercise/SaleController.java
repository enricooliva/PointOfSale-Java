package ca.jbrain.exercise;

/**
 * Created by enricooliva on 19/02/2017.
 */ //controller mediate the communication between display and catalog
public class SaleController {
    private Display display;
    private Catalog catalog;

    public SaleController(Display display, Catalog catalog) {
        this.display = display;
        this.catalog = catalog;
    }

    public void onBarcode(String barcode) {
        //SMELL Shoud I get an empty barcode at all?
        if ("".equals(barcode)) {
            display.diplayEmptyBarcode();
            return;
        }

        Price price = catalog.findPrice(barcode);
        if (price == null)
            display.displayProductNotFound(barcode);
        else
            display.displayPrice(price);
    }
}
