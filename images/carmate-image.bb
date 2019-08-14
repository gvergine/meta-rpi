SUMMARY = "A minimal image to be run in a car"
HOMEPAGE = "http://www.systemassembly.com"

IMAGE_LINGUAS = "en-us"

inherit image

DEPENDS += "bcm2835-bootfiles"

CORE_OS = " \
    kernel-modules \
    packagegroup-core-boot \
    procps \
    term-prompt \
    tzdata \
"

WIFI_SUPPORT = " \
    iw \
    linux-firmware-raspbian \
    wpa-supplicant \
"

ALSA += " \
    alsa-lib \
    alsa-tools \
    alsa-conf \
    alsa-state \
    alsa-utils \
    alsa-utils-scripts \
"

BLUETOOTH_SUPPORT += " \
    bluez5 \
"

IMAGE_INSTALL += " \
    ${ALSA} \
    ${CORE_OS} \
    ${WIFI_SUPPORT} \
    ${BLUETOOTH_SUPPORT} \
"

disable_bootlogd() {
    echo BOOTLOGD_ENABLE=no > ${IMAGE_ROOTFS}/etc/default/bootlogd
}

ROOTFS_POSTPROCESS_COMMAND += " \
    disable_bootlogd ; \
 "

export IMAGE_BASENAME = "carmate-image"
