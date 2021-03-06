@file:Suppress("unused")

package com.firstapp.robinpc.tongue_twisters_deluxe.utils

class Constants {
    companion object {
        const val APP_DATABASE = "twister_database"

        const val DEFAULT_STRING = "DEFAULT"
        const val DEFAULT_BOOLEAN = false

        //GENERIC CONSTANTS
        const val TYPE_LENGTH = 0
        const val TYPE_DIFFICULTY = 1
        const val TYPE_DAY_TWISTER = 2

        const val CHARSET_UTF_8 = "UTF-8"
        const val DEFAULT_VALUE_INT = 0
        const val DEFAULT_VALUE_FLOAT = 0f
        const val DEFAULT_VALUE_LONG = 0L
        const val DEFAULT_VALUE_STRING = ""

        //PREFERENCES CONSTANTS
        const val EXTRA_PREFERENCES_TWISTER = "PREFERENCES_TWISTER"

        //JSON DB CONSTANTS
        const val ALL_TWISTERS = "twister"
        const val LEVELS_BY_LENGTH = "length"
        const val LEVELS_BY_DIFFICULTY = "difficulty"
        const val MAIN_DB_PATH = "storage/twisters_storage.json"

        //OTHER DB CONSTANTS
        const val TWISTER_COUNT = 440
        const val LENGTH_LEVEL_COUNT = 3
        const val DIFFICULTY_LEVEL_COUNT = 10

        //MIN AND MAX
        const val MIN_TWISTER_INDEX = 1
        const val MAX_TWISTER_INDEX = 440

        //UNIT VALUES
        const val UNIT_VALUE_INT = 1
    }
}