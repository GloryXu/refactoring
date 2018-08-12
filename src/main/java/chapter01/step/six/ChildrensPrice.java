package chapter01.step.six;

public class ChildrensPrice extends Price {

    @Override
    public double getCharge(int daysRented) {
        double result = 1.5;
        if (daysRented > 3) {
            result += (daysRented - 3) * 1.5;
        }
        return result;
    }

    public int getPriceCode() {
        return Movie.CHILDRENS;
    }
}
