package hotelreservation.hotel.rate;

/**
 *
 * @author javidkhan
 */
public class Rate implements Comparable<Rate> {

    private double rate;
    private double regularWeekday;
    private double regularWeekend;
    private double rewardWeekday;
    private double rewardWeekend;

    /**
     *
     * @param regularWeekday weekday rate for regular customer
     * @param rewardWeekday weekday rate for reward customer
     * @param regularWeekend weekend rate for regular customer
     * @param rewardWeekend weekend rate for reward customer
     */
    public Rate(double regularWeekday, double rewardWeekday,
            double regularWeekend, double rewardWeekend) {
        this.regularWeekday = regularWeekday;
        this.regularWeekend = regularWeekend;
        this.rewardWeekday = rewardWeekday;
        this.rewardWeekend = rewardWeekend;
    }

    @Override
    public int compareTo(Rate o) {
        if (this.rate != 0
                && o.rate != 0) {
            if (this.rate > o.rate) {
                return 1;
            } else if (this.rate < o.rate) {
                return -1;
            } else {
                return 0;
            }

        } else {
            throw new IllegalArgumentException(
                    "Inavlid Rate object comparison: Rate value should not be 0");
        }

    }

    public double getRegularWeekday() {
        return regularWeekday;
    }

    public double getRegularWeekend() {
        return regularWeekend;
    }

    public double getRewardWeekday() {
        return rewardWeekday;
    }

    public double getRewardWeekend() {
        return rewardWeekend;
    }

    /**
     * Setter for rate to be used by the RateCalStrategy
     * @param rate
     */
    public void setRate(double rate) {
        this.rate = rate;
    }

    @Override
    public String toString() {
        return "" + rate;
    }
}
