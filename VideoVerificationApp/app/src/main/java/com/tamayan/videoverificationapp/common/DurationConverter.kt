package com.tamayan.videoverificationapp.common

object DurationConverter {

    fun convert(duration: String): String {
        var duration = duration.substring(2)

        val H: String
        var M: String
        var S: String

        val indOfH = duration.indexOf("H")
        if (indOfH > -1) {
            H = duration.substring(0, indOfH)
            duration = duration.substring(indOfH)
            duration = duration.replace("H", "")
        }
        else {
            H = ""
        }

        val indOfM = duration.indexOf("M")
        if (indOfM > -1) {
            M = duration.substring(0, indOfM)
            duration = duration.substring(indOfM)
            duration = duration.replace("M", "")
            if (H.isNotEmpty() && M.length == 1) {
                M = "0$M"
            }
        }
        else {
            M = if (H.isNotEmpty()) {
                "00"
            }
            else {
                "0"
            }
        }

        val indOfS = duration.indexOf("S")
        if (indOfS > -1) {
            S = duration.substring(0, indOfS)
            if (S.length == 1) {
                S = "0$S"
            }
        }
        else {
            S = "00"
        }
        return if (H.isNotEmpty()) {
            "$H:$M:$S"
        }
        else {
            "$M:$S"
        }
    }
}