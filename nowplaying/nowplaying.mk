# Pixel Now Playing — Rising-style sticky DeviceConfig flags for album art / On-Demand.
# Recognition path: in-tree SoftwareMusicHal + ASI + GMS NowPlayingPrebuilt.
# Clear Calling: vendor/oplus/clearcalling (Settings), not pixel-framework.

PRODUCT_PACKAGES += \
    NowPlayingFlags

PRODUCT_COPY_FILES += \
    vendor/alpha/nowplaying/flags/privapp-permissions-nowplaying-flags.xml:$(TARGET_COPY_OUT_SYSTEM_EXT)/etc/permissions/privapp-permissions-nowplaying-flags.xml
