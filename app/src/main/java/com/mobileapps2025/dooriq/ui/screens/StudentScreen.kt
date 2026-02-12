package com.mobileapps2025.dooriq.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mobileapps2025.dooriq.data.RoomDto
import com.mobileapps2025.dooriq.data.repository.RoomRepository

@Composable
fun StudentScreen(
    onNavigateToScanner: () -> Unit
) {
    val repository = remember { RoomRepository() }
    var rooms by remember { mutableStateOf<List<RoomDto>>(emptyList()) }
    var loading by remember { mutableStateOf(true) }

    LaunchedEffect(Unit) {
        try {
            rooms = repository.getRooms()
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            loading = false
        }
    }

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Button(
            onClick = onNavigateToScanner,
            modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp)
        ) { Text("Scan QR Code") }

        if (loading) {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text("Loading rooms...")
            }
        } else {
            LazyColumn(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                items(rooms) { room ->
                    Card(modifier = Modifier.fillMaxWidth()) {
                        Column(modifier = Modifier.padding(16.dp)) {
                            Text("Room: ${room.room_number}")
                            Text("Lecture: ${room.lecture}")
                            Text("Lecturer: ${room.lecturer}")
                            Text("Time: ${room.time}")
                        }
                    }
                }
            }
        }
    }
}