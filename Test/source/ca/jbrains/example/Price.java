package ca.jbrains.example;

/**
 * Created by enricooliva on 18/02/2017.
 */
public class Price {
    public static Price cents(int centsValue) {
        return new Price();
    }

    @Override
    public String toString() {
        return "a Price";
    }
}
