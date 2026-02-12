package com.mobileapps2025.dooriq.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

enum class UserRole { STUDENT, ADMIN }

@Composable
fun RoleSelectionScreen(
    onRoleSelected: (UserRole) -> Unit
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = "Select your role",
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(bottom = 32.dp)
            )

            Button(
                onClick = { onRoleSelected(UserRole.STUDENT) },
                modifier = Modifier.fillMaxWidth(0.7f).padding(bottom = 16.dp)
            ) { Text("Student") }

            Button(
                onClick = { onRoleSelected(UserRole.ADMIN) },
                modifier = Modifier.fillMaxWidth(0.7f)
            ) { Text("Admin") }
        }
    }
}