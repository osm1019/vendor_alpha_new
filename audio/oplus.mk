OPLUS_AUDIO_PATH := vendor/alpha/audio/oplus

PRODUCT_COPY_FILES += \
    $(foreach f,$(wildcard $(OPLUS_AUDIO_PATH)/ringtones/*.ogg),\
        $(f):$(TARGET_COPY_OUT_PRODUCT)/media/audio/ringtones/$(notdir $(f))) \
    $(foreach f,$(wildcard $(OPLUS_AUDIO_PATH)/notifications/*.ogg),\
        $(f):$(TARGET_COPY_OUT_PRODUCT)/media/audio/notifications/$(notdir $(f))) \
    $(foreach f,$(wildcard $(OPLUS_AUDIO_PATH)/alarms/*.ogg),\
        $(f):$(TARGET_COPY_OUT_PRODUCT)/media/audio/alarms/$(notdir $(f)))
