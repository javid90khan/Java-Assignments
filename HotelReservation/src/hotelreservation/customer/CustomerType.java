package hotelreservation.customer;

/**
 * CustomerType Enumeration to represent the possible type of customers
 * @author javidkhan
 */
public enum CustomerType {

    REGULAR("Regular"),

    REWARDS("Rewards");

    private String type;

    private CustomerType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return type;
    }
}
