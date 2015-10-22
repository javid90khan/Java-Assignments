package hotelreservation.hotel.rating;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author javidkhan 
 * Rating enumeration to represent standard Hotel Rating(1 to
 * 5 starts)
 */
public enum Rating {

    FIVE_STAR(5),
    FOUR_STAR(4),
    THREE_STAR(3),
    TWO_STAR(2),
    ONE_STAR(1);

    private int star;

    private Rating(int star) {
        this.star = star;
    }

    private static Map<Integer, Rating> map = new HashMap<>();
    /*create a map of all enum elements, that can-
    be used to retrieve the Rating based on int value
    */
    static {
        for (Rating rating : Rating.values()) {
            map.put(rating.star, rating);
        }
    }

    /**
     * returns Hotel Rating from it's numeric representation
     * @param no numeric rating (1 to 5)
     * @return 
     */
    public static Rating valueOf(int no) {
        if(map.get(no)==null){
            throw new IllegalArgumentException("Invalid rating");
        }
        return map.get(no);
    }

    @Override
    public String toString() {
        return this.name();
    }
}
