package com.tamayan.videoverificationapp.common

import org.threeten.bp.Duration

object DurationConverter {

    /**
     * PTHMS形式の文字列を渡すと、HH:mm:ssに変換します。
     */
    fun convert(time: String): String {
        val duration = Duration.parse(time)
        val hour = getHour(duration.toHours().toInt())
        val minute = getMinute(hour, (duration.toMinutes() % 60L).toInt())
        val second = getSecond((duration.seconds % 60L).toInt())

        return if (hour.isNotEmpty())
            "$hour:$minute:$second"
        else
            "$minute:$second"
    }

    private fun getHour(hour: Int): String {
        return if (hour > 0) hour.toString() else ""
    }

    private fun getMinute(hour: String, minute: Int): String {
        return if (minute > 0)
            if (hour.isNotEmpty() && minute < 10) "0$minute" else minute.toString()
        else
            if (hour.isNotEmpty()) "00" else "0"
    }

    private fun getSecond(second: Int): String {
        return if (second > 0)
            if (second < 10) "0$second" else second.toString()
        else
            "00"
    }
}