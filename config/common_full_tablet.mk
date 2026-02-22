# Inherit common stuff
$(call inherit-product, vendor/alpha/config/common.mk)

$(call inherit-product, $(SRC_TARGET_DIR)/product/window_extensions.mk)

# Freeform window management
PRODUCT_COPY_FILES += \
    frameworks/native/data/etc/android.software.freeform_window_management.xml:$(TARGET_COPY_OUT_PRODUCT)/etc/permissions/android.software.freeform_window_management.xml

# Settings
PRODUCT_PRODUCT_PROPERTIES += \
    persist.settings.large_screen_opt.enabled=true

# Tablet-specific overlay
PRODUCT_PACKAGE_OVERLAYS += vendor/alpha/overlay/tablet

TABLET_WIFI_ONLY ?= false
ifeq ($(TABLET_WIFI_ONLY),true)
  PRODUCT_PACKAGES += \
    EmergencyInfo

  PRODUCT_PACKAGE_OVERLAYS += vendor/alpha/overlay/wifionly
else
  $(call inherit-product, vendor/alpha/config/telephony.mk)
endif
