SUMMARY = "Upload bcm43xx firmware on boot"
LICENSE = "CLOSED"

SRC_URI = "file://Bcm43xxFirmwareUpload.service"

S = "${WORKDIR}"

inherit systemd

NATIVE_SYSTEMD_SUPPORT = "1"
SYSTEMD_PACKAGES = "${PN}"
SYSTEMD_SERVICE_${PN} = "Bcm43xxFirmwareUpload.service"
SYSTEMD_AUTO_ENABLE = "enable"

REQUIRED_DISTRO_FEATURES= "systemd"

FILES_${PN} += "${systemd_unitdir}/system/Bcm43xxFirmwareUpload.service"
