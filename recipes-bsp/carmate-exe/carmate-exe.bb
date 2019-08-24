DESCRIPTION = "carmate_exe" 
SECTION = "examples" 
LICENSE = "CLOSED" 
PR = "r0" 

SRC_URI = "git://github.com/gvergine/carmate.git;protocol=https"
SRCREV = "${AUTOREV}"
S = "${WORKDIR}/git"

inherit pkgconfig cmake

do_install() {
    install -d ${D}${bindir}
    install -m 0755 -d ${D}/opt/gps/tracking/
    install -m 0755 src/carmate/carmate ${D}/opt/gps/tracking/
}
