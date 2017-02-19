package ca.jbrains.example;

/**
 * Created by enricooliva on 19/02/2017.
 */
public class ConsoleDisplay {

    public void displayProductionNotFoundMessage(String barcodeNotFound) {
        System.out.println(String.format(
                "Product not found for %s", barcodeNotFound));
    }

    public void displayEmptyBarcodeMessage() {
        System.out.println(String.format(
                "Scanning error: empty barcode"));
    }

    public void displayPrice(Price price) {
        System.out.println(String.format(
                "$%,.2f", price.dollarValue()));
    }
}
