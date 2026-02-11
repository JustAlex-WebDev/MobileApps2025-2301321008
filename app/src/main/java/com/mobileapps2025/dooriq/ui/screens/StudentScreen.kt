package com.mobileapps2025.dooriq.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

// Data class for classroom
data class Room(
    val roomNumber: String,
    val lecture: String,
    val lecturer: String,
    val time: String
)

@Composable
fun StudentScreen(
    rooms: List<Room>,
    onNavigateToScanner: () -> Unit // callback for QR scanner
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // QR Scanner button at the top
        Button(
            onClick = onNavigateToScanner,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        ) {
            Text(text = "Scan QR Code")
        }

        // List of rooms
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier.fillMaxSize()
        ) {
            items(rooms) { room ->
                Card(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {
                        Text(
                            text = "Room: ${room.roomNumber}",
                            style = MaterialTheme.typography.titleLarge
                        )
                        Text(
                            text = "Lecture: ${room.lecture}",
                            style = MaterialTheme.typography.bodyLarge
                        )
                        Text(
                            text = "Lecturer: ${room.lecturer}",
                            style = MaterialTheme.typography.bodyLarge
                        )
                        Text(
                            text = "Time: ${room.time}",
                            style = MaterialTheme.typography.bodyLarge
                        )
                    }
                }
            }
        }
    }
}