DESCRIPTION = "carmate_exe" 
SECTION = "examples" 
LICENSE = "CLOSED" 
PR = "r0" 

SRC_URI = "git://github.com/gvergine/carmate.git;protocol=https"
SRC_URI += "file://carmate.service"

SRCREV = "${AUTOREV}"
S = "${WORKDIR}/git"

inherit pkgconfig cmake systemd

NATIVE_SYSTEMD_SUPPORT = "1"
SYSTEMD_PACKAGES = "${PN}"
SYSTEMD_SERVICE_${PN} = "carmate.service"
SYSTEMD_AUTO_ENABLE = "enable"

REQUIRED_DISTRO_FEATURES= "systemd"

do_install_append() {
    install -m 0755 -d ${D}/opt/gps/tracking/
    install -d ${D}${systemd_system_unitdir}
    install -m 0755 ${WORKDIR}/carmate.service ${D}${systemd_system_unitdir}
}

FILES_${PN} += "/opt/gps/tracking/"
FILES_${PN} += "/usr/bin/carmate"
FILES_${PN} += "/usr/share/infrastructure/cmake/InfrastructureConfig.cmake"
FILES_${PN} += "/usr/share/infrastructure/cmake/InfrastructureConfig-noconfig.cmake"
FILES_${PN} += "${systemd_system_unitdir}/carmate.service"

