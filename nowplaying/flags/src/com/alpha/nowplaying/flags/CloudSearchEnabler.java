package com.alpha.nowplaying.flags;

import android.content.Context;
import android.provider.DeviceConfig;
import android.provider.Settings;
import android.util.Log;

/**
 * Enables ASI Now Playing cloud album-art / On-Demand flags on non-Pixel ports.
 * Without these, Glide fails with "User not opted in or fetching disabled."
 *
 * <p>Ported from RisingOS {@code com.rising.nowplaying.flags.CloudSearchEnabler}.
 * Recognition itself uses st-hal software ST + Google ASI — this package only
 * keeps DeviceConfig sticky across boot and Play updates.
 */
public final class CloudSearchEnabler {
    private static final String TAG = "NowPlayingFlags";
    private static final String NAMESPACE = "device_personalization_services";

    private static final String[][] FLAGS = {
        {"NowPlaying__ambient_music_on_demand_enabled", "true"},
        {"NowPlaying__ambient_music_on_demand_classic_enabled_by_default", "true"},
        {"NowPlaying__cloud_api_allowed", "true"},
        {"NowPlaying__ambient_music_show_album_art", "true"},
        {"NowPlaying__ambient_music_download_album_art_via_astrea", "true"},
        {"NowPlaying__ambient_music_use_metadata_shards_database", "true"},
        {"NowPlaying__ambient_music_use_enhanced_matches_database", "true"},
        {"NowPlaying__on_demand_hide_if_fingerprinter_install_not_confirmed", "false"},
        {"NowPlaying__ambient_music_on_demand_search_use_new_opt_in_flow", "false"},
        {"NowPlaying__enable_now_playing_lock_screen_update", "true"},
        {"NowPlaying__enable_now_playing_sysui_updates", "true"},
        {"NowPlaying__enable_now_playing_updates", "true"},
    };

    private CloudSearchEnabler() {}

    public static void apply(Context context) {
        try {
            Settings.Secure.putInt(context.getContentResolver(), "now_playing_enabled", 1);
            Settings.Secure.putInt(context.getContentResolver(), "now_playing_suw_visited_by_user", 1);
        } catch (Throwable t) {
            Log.w(TAG, "Unable to set secure NP settings", t);
        }
        for (String[] flag : FLAGS) {
            try {
                DeviceConfig.setProperty(NAMESPACE, flag[0], flag[1], /* makeDefault */ true);
            } catch (Throwable t) {
                Log.w(TAG, "Unable to set DeviceConfig " + flag[0], t);
            }
        }
        Log.i(TAG, "Applied Now Playing album-art / On-Demand DeviceConfig flags");
    }
}
