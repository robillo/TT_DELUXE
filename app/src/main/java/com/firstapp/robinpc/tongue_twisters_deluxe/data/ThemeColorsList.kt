package com.firstapp.robinpc.tongue_twisters_deluxe.data

class ThemeColorsList(colors: IntArray) {

    var primaryColor: Int = 0

    var lightIntensity1: Int = 0
    var lightIntensity2: Int = 0
    var lightIntensity3: Int = 0
    var lightIntensity4: Int = 0
    var lightIntensity5: Int = 0

    var darkIntensity1: Int = 0
    var darkIntensity2: Int = 0
    var darkIntensity3: Int = 0
    var darkIntensity4: Int = 0
    var darkIntensity5: Int = 0

    init {
        primaryColor = colors[0]

        lightIntensity1 = colors[1]
        lightIntensity2 = colors[2]
        lightIntensity3 = colors[3]
        lightIntensity4 = colors[4]
        lightIntensity5 = colors[5]

        darkIntensity1 = colors[6]
        darkIntensity2 = colors[7]
        darkIntensity3 = colors[8]
        darkIntensity4 = colors[9]
        darkIntensity5 = colors[10]
    }
}
