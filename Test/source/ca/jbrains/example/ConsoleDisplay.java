package ca.jbrains.example;


/**
 * Created by enricooliva on 19/02/2017.
 */
public class ConsoleDisplay {

    public static final String PRODUCT_NOT_FOUND_FOR_MESSAGE_FORMAT = "Product not found for %s";
    public static final String SCANNING_ERROR_EMPTY_BARCODE_MESSAGE_FORMAT = "Scanning error: empty barcode";
    public static final String PRICE_IN_DOLLARS_MESSAGE_FORMAT = "$%,.2f";

    public void displayProductionNotFoundMessage(String barcodeNotFound) {
        displayMessage(PRODUCT_NOT_FOUND_FOR_MESSAGE_FORMAT, barcodeNotFound);
    }

    private void displayMessage(String messageTemplate, Object... placeholderValues) {
        render(messageTemplate(messageTemplate, placeholderValues));
    }

    private String messageTemplate(String messageTemplate, Object[] placeholderValues) {
        return String.format(messageTemplate,placeholderValues);
    }

    private void render(String text) {
        System.out.println(text);
    }

    public void displayEmptyBarcodeMessage() {
        displayMessage(SCANNING_ERROR_EMPTY_BARCODE_MESSAGE_FORMAT, "");
    }

    public void displayPrice(Price price) {
        displayMessage(PRICE_IN_DOLLARS_MESSAGE_FORMAT, price.dollarValue());
    }


//    public void display(MessageFormat messageFormat, Object... placehoders){
//        System.out.print(String.format(messageFormat,placehoders));
//    }
}
