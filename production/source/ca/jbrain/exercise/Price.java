package ca.jbrain.exercise;

/**
 * Created by enricooliva on 18/02/2017.
 * Value object
 */
public class Price {

    private final int centsValue;

    public Price(int centsValue){
        this.centsValue = centsValue;
    }

    public static Price cents(int centsValue) {
        return new Price(centsValue);
    }

    @Override
    public String toString() {
        return "a Price";
    }


    public double priceInDollars(int priceInCents) {
        return priceInCents / 100.0d;
    }

    public double dollarValue() {
        return priceInDollars(this.centsValue);
    }
}
