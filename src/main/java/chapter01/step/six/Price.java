package chapter01.step.six;

public abstract class Price {

    public abstract double getCharge(int daysRented);

    public abstract int getPriceCode();

    public int getFrequentRenterPoints(int daysRented){
        return 1;
    }
}
