SUMMARY = "A minimal image to be run in a car"
HOMEPAGE = "http://www.systemassembly.com"

IMAGE_LINGUAS = "en-us"

inherit image

DEPENDS += "bcm2835-bootfiles"

DISTRO_FEATURES_append += " bluez5 bluetooth wifi"

CORE_OS = " \
    firewall \
    ifupdown \
    iptables \
    kernel-modules \
    ntp \
    ntp-tickadj \
    openssh openssh-keygen openssh-sftp-server \
    packagegroup-core-boot \
    procps \
    rndaddtoentcnt \
    rng-tools \
    term-prompt \
    tzdata \
"

WIFI_SUPPORT = " \
    crda \
    iw \
    linux-firmware-raspbian \
    wpa-supplicant \
"

ALSA += " \
    libasound \
    libavcodec \
    libavdevice \
    libavfilter \
    libavformat \
    libavutil \
    libpostproc \
    libswresample \
    libswscale \
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
