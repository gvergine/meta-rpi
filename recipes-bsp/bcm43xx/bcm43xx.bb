SUMMARY = "Upload bcm43xx firmware on boot"
LICENSE = "CLOSED"

SRC_URI = "file://Bcm43xxFirmwareUpload.service"
SRC_URI += "file://btagent.service"

S = "${WORKDIR}"

inherit systemd

NATIVE_SYSTEMD_SUPPORT = "1"
SYSTEMD_PACKAGES = "${PN}"
SYSTEMD_SERVICE_${PN} = "Bcm43xxFirmwareUpload.service"
SYSTEMD_SERVICE_${PN} += "btagent.service"
SYSTEMD_AUTO_ENABLE = "enable"

REQUIRED_DISTRO_FEATURES= "systemd"

do_install () {
    install -d ${D}${systemd_system_unitdir}
    install -m 0755 ${WORKDIR}/Bcm43xxFirmwareUpload.service ${D}${systemd_system_unitdir}
    install -m 0755 ${WORKDIR}/btagent.service ${D}${systemd_system_unitdir}
}

FILES_${PN} += "${systemd_system_unitdir}/Bcm43xxFirmwareUpload.service"
FILES_${PN} += "${systemd_system_unitdir}/btagent.service"
