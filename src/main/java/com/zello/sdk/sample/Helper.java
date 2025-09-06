package com.zello.sdk.sample;

import android.content.Context;
import android.content.SharedPreferences;

@SuppressWarnings("WeakerAccess")
public class Helper {

	private static final String _loginPref = "login";

	public static void saveValue(Context context, String key, String data) {
		if (context == null || key == null || key.isEmpty()) {
			return;
		}
		SharedPreferences settings = context.getSharedPreferences(_loginPref, 0);
		SharedPreferences.Editor editor = settings.edit();
		editor.putString(key, data == null ? "" : data);
		editor.apply();
	}

	public static String loadValue(Context context, String key) {
		if (context == null || key == null || key.isEmpty()) {
			return "";
		}
		try {
			SharedPreferences settings = context.getSharedPreferences(_loginPref, 0);
			return settings.getString(key, "");
		} catch (Throwable t) {
			// Google Play reports sporadic ClassCastException
		}
		return "";
	}

}
