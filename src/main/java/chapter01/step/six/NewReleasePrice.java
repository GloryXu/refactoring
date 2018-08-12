package chapter01.step.six;

public class NewReleasePrice extends Price {

    @Override
    public double getCharge(int daysRented) {
        return daysRented * 3;
    }

    public int getPriceCode() {
        return Movie.NEW_RELEASE;
    }

    @Override
    public int getFrequentRenterPoints(int daysRented) {
        // add bonus for a two day new release rental
        return daysRented > 1 ? 2 : 1;
    }
}
