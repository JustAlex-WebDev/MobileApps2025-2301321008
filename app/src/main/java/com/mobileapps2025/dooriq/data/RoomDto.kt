package com.mobileapps2025.dooriq.data

import kotlinx.serialization.Serializable

@Serializable
data class RoomDto(
    val id: String,
    val room_number: String,
    val lecture: String,
    val lecturer: String,
    val time: String,
    val deleted: Boolean = false
)