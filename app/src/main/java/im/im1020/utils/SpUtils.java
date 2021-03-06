package im.im1020.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.hyphenate.chat.EMClient;

import im.im1020.imApplication;

/**
 * Created by Mancy_Lin on 2017-02-17.
 */

public class SpUtils {

    public static final String NEW_INVITE = "new_invite";
    private static SpUtils instace = new SpUtils();
    private static SharedPreferences mSp = null;

    public static SpUtils getInstace() {

        if (mSp == null) {
            mSp = imApplication.getContext().
                    getSharedPreferences(
                            EMClient.getInstance().getCurrentUser(),
                            Context.MODE_PRIVATE
                    );
        }

        return instace;
    }

    public void destory() {
        mSp = null;
    }

    // 保存
    public void save(String key, Object value) {

        if (value instanceof String) {
            mSp.edit().putString(key, (String) value).commit();
        } else if (value instanceof Boolean) {
            mSp.edit().putBoolean(key, (Boolean) value).commit();
        } else if (value instanceof Integer) {
            mSp.edit().putInt(key, (Integer) value).commit();
        }
    }

    // 读取
    // 读取String类型数据
    public String getString(String key, String defValue) {
        return mSp.getString(key, defValue);
    }

    // 读取boolean类型数据
    public boolean getBoolean(String key, boolean defValue) {
        return mSp.getBoolean(key, defValue);
    }

    // 读取int类型数据
    public int getInt(String key, int defValue) {
        return mSp.getInt(key, defValue);
    }
}
