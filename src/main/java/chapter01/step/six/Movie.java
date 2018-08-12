package chapter01.step.six;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Movie {

    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;
    public static final int CHILDRENS = 2;

    private String title;

    private Price _price;

    int priceCode;

    public Movie(String title, int priceCode) {
        this.title = title;
        this.priceCode = priceCode;
        setPriceCode(priceCode);
    }

    /**
     * 租期长度
     * <p>
     * <p>
     * 说明：该方法之前都是在Rental类中
     * 为什么选择将租期长度传给Movie对象，而不是将影片类型传给Rental对象呢？
     * 因为本系统可能发生的变化是加入新影片类型，这种变化带有不稳定倾向。如果影片类型有所变化，我希望尽量控制它造成的影响，
     * 所以选择在Movie对象内计算费用
     *
     * @param daysRented
     * @return
     */
    public double getCharge(int daysRented) {
        return _price.getCharge(daysRented);
    }

    public int getPriceCode() {
        return _price.getPriceCode();
    }

    public void setPriceCode(int priceCode) {
        switch (priceCode) {
            case REGULAR:
                _price = new RegularPrice();
                break;
            case CHILDRENS:
                _price = new ChildrensPrice();
                break;
            case NEW_RELEASE:
                _price = new NewReleasePrice();
                break;
            default:
                throw new IllegalArgumentException("Incorrect Price Code");
        }
    }

    public int getFrequentRenterPoints(int daysRented) {
        return _price.getFrequentRenterPoints(daysRented);
    }
}
