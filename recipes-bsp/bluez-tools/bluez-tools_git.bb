DESCRIPTION = "Bluez Tools"
HOMEPAGE = "https://github.com/khvzak/bluez-tools"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=12f884d2ae1ff87c09e5b7ccc2c4ca7e"

RDEPENDS_${PN} = "bluez5"
SRCREV = "${AUTOREV}"
S = "${WORKDIR}/git"
B = "${WORKDIR}/build"

SRC_URI = "git://github.com/khvzak/bluez-tools;protocol=git"

DEPENDS = "glib-2.0 dbus-glib readline"

inherit autotools pkgconfig

do_install() {
    install -d ${D}${bindir}
    install -m 755 ${B}/src/bt-adapter ${D}${bindir}
    install -m 755 ${B}/src/bt-agent   ${D}${bindir}
    install -m 755 ${B}/src/bt-device  ${D}${bindir}
    install -m 755 ${B}/src/bt-network ${D}${bindir}
    install -m 755 ${B}/src/bt-obex    ${D}${bindir}
}
