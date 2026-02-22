# Inherit common config
$(call inherit-product, vendor/alpha/config/common.mk)

# Enable support of one-handed mode
PRODUCT_PRODUCT_PROPERTIES += \
    ro.support_one_handed_mode?=true

$(call inherit-product, vendor/alpha/config/telephony.mk)
