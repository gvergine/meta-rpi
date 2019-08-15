SUMMARY = "Upload bcm43xx firmware on boot"
LICENSE = "CLOSED"

SRC_URI = "file://bcm43xxService/Bcm43xxFirmwareUpload.service"

S = "${WORKDIR}"

inherit systemd

SYSTEMD_SERVICE = "Bcm43xxFirmwareUpload.service"

REQUIRED_DISTRO_FEATURES= "systemd"
