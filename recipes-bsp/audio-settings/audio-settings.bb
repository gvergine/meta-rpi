SUMMARY = "Set audio to 100% volume on boot"
LICENSE = "CLOSED"

SRC_URI = "file://audiosettings.service"

S = "${WORKDIR}"

inherit systemd

NATIVE_SYSTEMD_SUPPORT = "1"
SYSTEMD_PACKAGES = "${PN}"
SYSTEMD_SERVICE_${PN} = "audiosettings.service"
SYSTEMD_AUTO_ENABLE = "enable"

REQUIRED_DISTRO_FEATURES= "systemd"

do_install () {
    install -d ${D}${systemd_system_unitdir}
    install -m 0755 ${WORKDIR}/audiosettings.service ${D}${systemd_system_unitdir}
}

FILES_${PN} += "${systemd_system_unitdir}/audiosettings.service"
