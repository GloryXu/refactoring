package chapter01.step.three;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 *
 */
@Getter
@Setter
@ToString
public class Rental {

    Movie movie;

    int daysRented;


    public double getCharge() {
        int result = 0;
        // determine amount for each line
        switch(getMovie().getPriceCode()) {
            case Movie.REGULAR:
                result += 2;
                if(getDaysRented() > 2)
                    result += (getDaysRented() - 2) * 1.5;
                break;
            case Movie.NEW_RELEASE:
                result += getDaysRented() *3;
                break;
            case Movie.CHILDRENS:
                result += 1.5;
                if(getDaysRented() > 3) {
                    result += (getDaysRented() - 3) * 1.5;
                }
                break;
        }
        return result;
    }
}
