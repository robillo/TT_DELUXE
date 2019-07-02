package com.firstapp.robinpc.tongue_twisters_deluxe.data.model

data class Twister(
        val id: Int,
        val name: String,
        val twister: String,
        val length: Int,
        val difficulty: Int,
        val iconUrl: String,
        val hint: String,
        val isLocked: Boolean
)