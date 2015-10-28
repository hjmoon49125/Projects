package Data;

/**
 * Created by META on 2015/10/26.
 */
public final class Constants {

    private Constants(){
        throw new IllegalStateException(Constants.class.getSimpleName() +
            " this is a Constants Class and can not be new");
    }

    public static final String KEY_FOOD_NUM = "FOOD_NUM";
    public static final String KEY_FOOD = "FOOD_%d";
    public static final String KEY_FOOD_WEIGHT = "WEIGHT_%d";

}
