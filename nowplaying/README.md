# Alpha Now Playing (Rising-style)

Lightweight port of RisingOS `vendor/rising/nowplaying` flags helper.

## What this package does

- Ships **`NowPlayingFlags`** (`com.alpha.nowplaying.flags`) — privileged platform app
- On boot / package-replaced of ASI / NP / as.oss, applies DeviceConfig for:
  - On-Demand / cloud search opt-in
  - Album art (including Astrea download)
  - Online metadata shards
  - SysUI lockscreen update flags
- Sets `now_playing_enabled` + `now_playing_suw_visited_by_user`

## What lives elsewhere

| Piece | Location |
|-------|----------|
| NP APK + `music_detector` + `matcher_tah` | `vendor/pixel/gms` |
| ASI ↔ as.oss associations | `nowplaying.xml` / `google.xml` (gms) |
| Software SoundTrigger path | `vendor/qcom/.../st-hal-ar` |
| DeviceConfig defaults (overlay) | `vendor/alpha/overlay/.../config.xml` |
| Settings Sound → ASI row | `packages/apps/Settings` |
| **Clear Calling** | **`vendor/pixel-framework` SettingsGoogle** (`OplusClearCalling*`) |

## Not included (by design)

- No poll FGS / AmbientIndication publisher (`NowPlayingSoftware` is superseded)
- No Clear Calling UI here — use pixel-framework
