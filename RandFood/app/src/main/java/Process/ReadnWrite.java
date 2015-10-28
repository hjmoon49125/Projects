package Process;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

/**
 * Created by META on 2015/10/26.
 */
public class ReadnWrite {

    private final String fileName = "SavedData";
    private SharedPreferences sharedPreferences;

    // Singleton
    private static ReadnWrite instance = null;
    public static ReadnWrite getInstance(){
        if(null == instance) {
            throw new IllegalStateException(ReadnWrite.class.getSimpleName() +
                    " is not initialized, call initializeInstance(..) method first.");
        }
        return instance;
    }
    public static void initializeInstance(Context context) {
        if (null == instance) {
            instance = new ReadnWrite(context);
        }
    }

    // Constructor
    private ReadnWrite(Context context) {
        sharedPreferences = context.getSharedPreferences(fileName, Context.MODE_PRIVATE);
    }

    // get SharedPreferences
    private SharedPreferences getPreferences() {
        return sharedPreferences;
    }

    // get Editor
    private Editor getEditor() {
        return getPreferences().edit();
    }

    // 寫 Boolean
    public void writeBoolean(String key, boolean value) {
        getEditor().putBoolean(key, value).apply();
    }

    // 讀 Boolean
    public boolean readBoolean(String key, boolean defValue) {
        return getPreferences().getBoolean(key, defValue);
    }

    // 寫 Byte
    public void writeByte(String key, byte value) {
        getEditor().putString(key, Byte.toString(value)).apply();
    }

    // 讀 Byte
    public byte readByte(String key, String defValue) {
        return Byte.parseByte(getPreferences().getString(key, defValue));
    }

    // 寫 Int
    public void writeInteger(String key, int value) {
        getEditor().putInt(key, value).apply();
    }

    // 讀 Int
    public int readInteger(String key, int defValue) {
        return getPreferences().getInt(key, defValue);
    }

    // 寫 String
    public void writeString(String key, String value) {
        getEditor().putString(key, value).apply();
    }

    // 讀 String
    public String readString(String key, String defValue) {
        return getPreferences().getString(key, defValue);
    }

    // 寫 Float
    public void writeFloat(String key, float value) {
        getEditor().putFloat(key, value).apply();
    }

    // 讀 Float
    public float readFloat(String key, float defValue) {
        return getPreferences().getFloat(key, defValue);
    }

    // 寫 Long
    public void writeLong(String key, long value) {
        getEditor().putLong(key, value).apply();
    }

    // 讀 Long
    public long readLong(String key, long defValue) {
        return getPreferences().getLong(key, defValue);
    }
}
