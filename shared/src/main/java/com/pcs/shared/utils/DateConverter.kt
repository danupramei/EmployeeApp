package com.pcs.shared.utils

import java.text.SimpleDateFormat
import java.util.Locale
import java.util.TimeZone

class DateConverter {
    private val YYYY_MM_DD_T_HHMMSS_SSSZ = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"
    private val DD_MMM_YYYY = "dd MMM yyyy"
    private val UTC_TIME = "UTC"

    fun formatDate(inputDate: String): String {
        val inputFormat = SimpleDateFormat(YYYY_MM_DD_T_HHMMSS_SSSZ, Locale.getDefault())
        inputFormat.timeZone = TimeZone.getTimeZone(UTC_TIME)

        val outputFormat = SimpleDateFormat(DD_MMM_YYYY, Locale.getDefault())

        val date = inputFormat.parse(inputDate)
        return outputFormat.format(date!!)
    }
}