package chapter01.step.six;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 租客
 */
@Getter
@Setter
@ToString
public class Rental {

    Movie movie;

    int daysRented;

    double getCharge() {
        return movie.getCharge(daysRented);
    }

    public int getFrequentRenterPoints() {
        return movie.getFrequentRenterPoints(daysRented);
    }
}
