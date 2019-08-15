SUMMARY = "Upload bcm43xx firmware on boot"
LICENSE = "CLOSED"

SRC_URI = "file://Bcm43xxFirmwareUpload.service"
SRC_URI += " file://AutoPairAndTrust.service"

S = "${WORKDIR}"

inherit systemd

NATIVE_SYSTEMD_SUPPORT = "1"
SYSTEMD_PACKAGES = "${PN}"
SYSTEMD_SERVICE_${PN} = "Bcm43xxFirmwareUpload.service"
SYSTEMD_SERVICE_${PN} += " AutoPairAndTrust.service"
SYSTEMD_AUTO_ENABLE = "enable"

REQUIRED_DISTRO_FEATURES= "systemd"

do_install () {
    install -d ${D}${systemd_system_unitdir}
    install -m 0644 ${WORKDIR}/Bcm43xxFirmwareUpload.service ${D}${systemd_system_unitdir}
    install -m 0644 ${WORKDIR}/AutoPairAndTrust.service ${D}${systemd_system_unitdir}
}

FILES_${PN} += "${systemd_system_unitdir}/Bcm43xxFirmwareUpload.service"
FILES_${PN} += "${systemd_system_unitdir}/AutoPairAndTrust.service"
