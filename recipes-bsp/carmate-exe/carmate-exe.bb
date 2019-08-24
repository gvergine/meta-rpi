DESCRIPTION = "carmate_exe" 
SECTION = "examples" 
LICENSE = "CLOSED" 
PR = "r0" 

SRC_URI = "git://github.com/gvergine/carmate.git;protocol=https"
SRCREV = "${AUTOREV}"
S = "${WORKDIR}/git"

inherit pkgconfig cmake

do_install_append() {
    install -m 0755 -d ${D}/opt/gps/tracking/
}

FILES_${PN} += "/opt/gps/tracking/"
