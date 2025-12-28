package com.masdika.audiobookcompose.utils

import java.util.Locale

fun formatDuration(seconds: Long): String {
    val hours = seconds / 3600
    val minutes = (seconds % 3600) / 60
    val remainingSeconds = seconds % 60

    return String.format(Locale.US, "%d:%02d:%02d", hours, minutes, remainingSeconds)
}