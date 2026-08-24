package com.alpha.nowplaying.flags;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;

public class PackageReplacedReceiver extends BroadcastReceiver {
    private static final String TAG = "NowPlayingFlags";

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent == null) return;
        String action = intent.getAction();
        if (Intent.ACTION_MY_PACKAGE_REPLACED.equals(action)) {
            Log.i(TAG, "Own package replaced; re-applying flags");
            CloudSearchEnabler.apply(context);
            return;
        }
        if (Intent.ACTION_PACKAGE_REPLACED.equals(action)) {
            Uri data = intent.getData();
            String pkg = data != null ? data.getSchemeSpecificPart() : null;
            if ("com.google.android.as".equals(pkg)
                    || "com.google.android.apps.pixel.nowplaying".equals(pkg)
                    || "com.google.android.as.oss".equals(pkg)) {
                Log.i(TAG, "Package replaced: " + pkg + "; re-applying flags");
                CloudSearchEnabler.apply(context);
            }
        }
    }
}
