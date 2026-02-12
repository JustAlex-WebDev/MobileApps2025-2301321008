package com.mobileapps2025.dooriq.data.repository

import com.mobileapps2025.dooriq.data.RoomDto
import com.mobileapps2025.dooriq.data.SupabaseManager
import io.github.jan.supabase.postgrest.from

class RoomRepository {
    suspend fun getRooms(): List<RoomDto> {
        return try {
            SupabaseManager.client
                .from("rooms")
                .select()
                .decodeList()
        } catch (e: Exception) {
            e.printStackTrace()
            emptyList()
        }
    }
}