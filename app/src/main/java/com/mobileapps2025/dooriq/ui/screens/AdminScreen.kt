package com.mobileapps2025.dooriq.ui.screens

import java.util.UUID
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mobileapps2025.dooriq.data.RoomDto
import com.mobileapps2025.dooriq.data.repository.AdminRepository
import kotlinx.coroutines.launch

@Composable
fun AdminScreen() {
    val scope = rememberCoroutineScope()
    var rooms by remember { mutableStateOf(listOf<RoomDto>()) }
    var loading by remember { mutableStateOf(true) }

    LaunchedEffect(Unit) {
        try {
            rooms = AdminRepository.getAllRooms()
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            loading = false
        }
    }

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Button(
            onClick = {
                scope.launch {
                    try {
                        val newRoom = RoomDto(
                            id = UUID.randomUUID().toString(),
                            room_number = "404",
                            lecture = "New Lecture",
                            lecturer = "New Lecturer",
                            time = "12:00 - 13:00"
                        )
                        AdminRepository.addRoom(newRoom)
                        rooms = AdminRepository.getAllRooms() // refresh
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }
                }
            },
            modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp)
        ) { Text("Add Room") }

        if (loading) {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text("Loading rooms...")
            }
        } else {
            LazyColumn(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                items(rooms) { room ->
                    Card(modifier = Modifier.fillMaxWidth()) {
                        Row(
                            modifier = Modifier.padding(16.dp),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Column {
                                Text("Room: ${room.room_number}")
                                Text("Lecture: ${room.lecture}")
                                Text("Lecturer: ${room.lecturer}")
                                Text("Time: ${room.time}")
                            }
                            Column {
                                Button(onClick = {
                                    scope.launch {
                                        try {
                                            val updatedRoom = room.copy(
                                                lecture = "${room.lecture} (Updated)"
                                            )
                                            AdminRepository.updateRoom(updatedRoom)
                                            rooms = AdminRepository.getAllRooms() // refresh
                                        } catch (e: Exception) {
                                            e.printStackTrace()
                                        }
                                    }
                                }) { Text("Update") }

                                Spacer(modifier = Modifier.height(8.dp))

                                Button(onClick = {
                                    scope.launch {
                                        try {
                                            AdminRepository.deleteRoom(room.id)
                                            rooms = AdminRepository.getAllRooms() // refresh
                                        } catch (e: Exception) {
                                            e.printStackTrace()
                                        }
                                    }
                                }) { Text("Delete") }
                            }
                        }
                    }
                }
            }
        }
    }
}