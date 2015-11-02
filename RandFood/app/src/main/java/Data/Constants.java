package Data;

import android.util.Log;

/**
 * Created by META on 2015/10/26.
 */
public final class Constants {

    private Constants(){
        throw new IllegalStateException(Constants.class.getSimpleName() +
            " this is a Constants Class and can not be new");
    }

    // 存檔的 key value 值
    public static final String KEY_FOOD_NUM = "FOOD_NUM";
    public static final String KEY_FOOD = "FOOD_%d";
    public static final String KEY_FOOD_WEIGHT = "WEIGHT_%d";

    // 回傳更新指令的值
    public static final int ADD_REQUEST = 10;

    // 自製 Debug LOG
    private static final String ACTIVITY_TAG = "Debug Log";
    public static void DebugLog(String value){Log.i(ACTIVITY_TAG,  value);}
}
