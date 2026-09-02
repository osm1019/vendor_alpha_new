# Alpha Now Playing (Rising-style)

Lightweight port of RisingOS `vendor/rising/nowplaying` flags helper.

## What this package does

- Ships **`NowPlayingFlags`** (`com.alpha.nowplaying.flags`) — privileged platform app
- On boot / package-replaced of ASI / NP / as.oss, applies DeviceConfig for:
  - On-Demand / cloud search opt-in
  - Album art (including Astrea download)
  - Online metadata shards
  - SysUI lockscreen update flags
- Marks `now_playing_suw_visited_by_user` so Pixel's setup wizard is skipped
- Seeds `now_playing_enabled` on first boot if the user has not chosen yet

## What lives elsewhere

| Piece | Location |
|-------|----------|
| NP APK + `music_detector` + `matcher_tah` | `vendor/pixel/gms` |
| ASI ↔ as.oss / NP associations | `nowplaying.xml` / `google.xml` (gms) |
| Software SoundTrigger path | `SoftwareMusicHal` in `frameworks/base` |
| DeviceConfig defaults (overlay) | `vendor/alpha/overlay/.../config.xml` |
| Settings Sound → ASI row | `packages/apps/Settings` |
| **Clear Calling** | **`vendor/oplus/clearcalling`** (Oplus voice-call NC; wired into Settings) |

## Not included (by design)

- No poll FGS / AmbientIndication publisher (`NowPlayingSoftware` is superseded)
- No Clear Calling UI here — see `vendor/oplus/clearcalling`
