package ca.jbrain.exercise;

/**
 * Created by enricooliva on 19/02/2017.
 */
public interface Display {
    void displayPrice(Price price);

    void displayProductNotFound(String with);

    void diplayEmptyBarcode();
}
