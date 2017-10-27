package com.touchmenotapps.blocks.farmework;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by i7 on 27-10-2017.
 */

public class AppPreferences {

    private SharedPreferences mAppPrefs;

    public AppPreferences(Context context) {
        mAppPrefs = context.getSharedPreferences("BlocksPreferences", 0);
    }

    public void setLoggedIn() {
        SharedPreferences.Editor edit = mAppPrefs.edit();
        edit.putBoolean("appLoggedIn", true);
        edit.commit();
    }

    public void setLopggedOut() {
        SharedPreferences.Editor edit = mAppPrefs.edit();
        edit.putBoolean("appLoggedIn", false);
        edit.commit();
    }

    public boolean isUserLoggedIn() {
        return mAppPrefs.getBoolean("appLoggedIn", false);
    }

    public void loggedInAsKid(boolean isTrue) {
        SharedPreferences.Editor edit = mAppPrefs.edit();
        edit.putBoolean("appKidLoggedIn", isTrue);
        edit.commit();
    }

    public boolean isLoggedInAsKid() {
        return mAppPrefs.getBoolean("appKidLoggedIn", false);
    }

    public void setChildAvatar(boolean isBoy) {
        SharedPreferences.Editor edit = mAppPrefs.edit();
        edit.putBoolean("appAvatar", isBoy);
        edit.commit();
    }

    public boolean getChildAvatar() {
        return mAppPrefs.getBoolean("appAvatar", false);
    }

    public void setChildName(String name) {
        SharedPreferences.Editor edit = mAppPrefs.edit();
        edit.putString("childName", name);
        edit.commit();
    }

    public String getChildName() {
        return mAppPrefs.getString("childName", "");
    }
}
