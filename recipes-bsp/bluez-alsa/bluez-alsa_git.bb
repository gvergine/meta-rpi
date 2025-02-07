SUMMARY = "Bluetooth Audio ALSA Backend"
HOMEPAGE = "https://github.com/Arkq/bluez-alsa"
SECTION = "libs"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=bb3e99e80c5d718213f35ae1def4c106"

SRC_URI = "git://github.com/Arkq/bluez-alsa.git;protocol=https;branch=master"
SRCREV = "9045edb436ea755f395a2e09e4525b5defad286a"

SRC_URI += "file://bluez-alsa.service"
SRC_URI += "file://bluealsaplay.service"

S  = "${WORKDIR}/git"

DEPENDS += "alsa-lib bluez5 systemd glib-2.0 sbc"

PACKAGECONFIG[aac]  = "--enable-aac, --disable-aac, "
PACKAGECONFIG[aptx] = "--enable-aptx,--disable-aptx,"
PACKAGECONFIG[hcitop]   = "--enable-hcitop,  --disable-hcitop,  libbsd ncurses"

inherit autotools pkgconfig
inherit systemd

SYSTEMD_AUTO_ENABLE = "enable"
SYSTEMD_SERVICE_${PN} = "bluez-alsa.service"
SYSTEMD_SERVICE_${PN} += "bluealsaplay.service"

PACKAGECONFIG += "hcitop"

do_install_append () {
    install -d ${D}${base_libdir}/systemd/system
    install -m 0644 ${WORKDIR}/bluez-alsa.service ${D}${base_libdir}/systemd/system
    install -m 0644 ${WORKDIR}/bluealsaplay.service ${D}${base_libdir}/systemd/system
}

FILES_${PN} += "\
  ${datadir}/alsa/alsa.conf.d/20-bluealsa.conf\
  ${libdir}/alsa-lib/libasound_module_ctl_bluealsa.so\
  ${libdir}/alsa-lib/libasound_module_pcm_bluealsa.so\
"
