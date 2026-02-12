package com.mobileapps2025.dooriq.data.repository

import com.mobileapps2025.dooriq.data.RoomDto
import com.mobileapps2025.dooriq.data.SupabaseManager
import io.github.jan.supabase.postgrest.from

object AdminRepository {

    private val client = SupabaseManager.client

    suspend fun getAllRooms(): List<RoomDto> =
        client.from("rooms")
            .select()
            .decodeList<RoomDto>()

    suspend fun addRoom(room: RoomDto) =
        client.from("rooms")
            .insert(room)
            .decodeList<RoomDto>()

    suspend fun updateRoom(room: RoomDto) =
        client.from("rooms")
            .update(room) {
                filter { eq("id", room.id) }
            }

    suspend fun deleteRoom(roomId: String) =
        client.from("rooms")
            .delete {
                filter { eq("id", roomId) }
            }
}