package ru.netology

fun hoursToText(hours: Int): String {
    return if (hours in 11..20) {
        String.format("%d часов назад",hours)
    } else {
        when (hours%10) {
            1 -> String.format("%d час", hours)
            in 2..4 -> String.format("%d часа", hours)
            else -> String.format("%d часов", hours)
        }
    }
}

fun minsToText(mins: Int): String {
    return if (mins in 11..14) {
        String.format("%d минут назад",mins)
    } else {
        when (mins%10) {
            1 -> String.format("%d минуту", mins)
            in 2..4 -> String.format("%d минуты", mins)
            else -> String.format("%d минут", mins)
        }
    }
}

fun agoToText(sec: Int): String {
    val result = "был(а) "
    val hours: Int = sec / 3600
    val mins: Int = (sec - hours*3600) / 60
    val dayInSecs: Int = 24*60*60
    return when (sec) {
        in 0..60 -> result + "только что"
        in 61..60*60 -> result + String.format("%s назад", minsToText(mins))
        in 60*60+1.. dayInSecs -> result + String.format("%s назад", hoursToText(hours))
        in dayInSecs+1..2*dayInSecs -> result + "сегодня"
        in 2*dayInSecs+1..3*dayInSecs -> result + "вчера"
        else -> result + "давно"
    }
}

fun main() {
    println(3673/60)
    println(agoToText(3673))
}