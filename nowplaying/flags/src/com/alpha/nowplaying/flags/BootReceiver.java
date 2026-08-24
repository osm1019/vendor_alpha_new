package com.alpha.nowplaying.flags;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class BootReceiver extends BroadcastReceiver {
    private static final String TAG = "NowPlayingFlags";

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i(TAG, "Boot event " + (intent != null ? intent.getAction() : null));
        CloudSearchEnabler.apply(context);
    }
}
