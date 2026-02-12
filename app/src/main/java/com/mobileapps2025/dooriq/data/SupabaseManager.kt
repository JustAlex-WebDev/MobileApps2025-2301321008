package com.mobileapps2025.dooriq.data

import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.postgrest.Postgrest

object SupabaseManager {

    val client: SupabaseClient = createSupabaseClient(
        supabaseUrl = "https://nksrhkjabzocrlvqyurh.supabase.co",
        supabaseKey = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6Im5rc3Joa2phYnpvY3JsdnF5dXJoIiwicm9sZSI6ImFub24iLCJpYXQiOjE3NzA4MzE5MzgsImV4cCI6MjA4NjQwNzkzOH0.qBHqLVsHYRzvYsqnimwexXTMv0oapoLLMCaO_tlugGI"
    ) {
        install(Postgrest)
    }
}