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
    public static final int MOD_REQUEST = 20;

    // Mod Food Key Value
    public static final String MOD_KEY = "mod_key";
    public static final String MOD_Value = "mod_value";

    public enum ACTION_STATE {
        RAND_ANIMATE,
        RAND_STOP
    }

    // 自製 Debug LOG
    private static final String ACTIVITY_TAG = "Debug Log";
    public static void DebugLog(String value){Log.i(ACTIVITY_TAG,  value);}
}
