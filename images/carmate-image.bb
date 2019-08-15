# Base this image on core-image-minimal
include recipes-core/images/core-image-minimal.bb

SUMMARY = "A minimal image to be run in a car"
HOMEPAGE = "http://www.systemassembly.com"

# Include modules in rootfs
IMAGE_INSTALL += " \
	kernel-modules \
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
    bcm43xx \
"

IMAGE_INSTALL += " \
    ${ALSA} \
    ${BLUETOOTH_SUPPORT} \
"

export IMAGE_BASENAME = "carmate-image"
