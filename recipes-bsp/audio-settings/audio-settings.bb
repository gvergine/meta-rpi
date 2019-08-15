SUMMARY = "Set audio to 100% volume on boot"
LICENSE = "CLOSED"

SRC_URI = "file://asound.state"

S = "${WORKDIR}"

do_install () {
    install -d ${D}/var/lib/alsa
    install -m 0755 ${WORKDIR}/asound.state ${D}/var/lib/alsa
}

FILES_${PN} += "/var/lib/alsa/asound.state"
