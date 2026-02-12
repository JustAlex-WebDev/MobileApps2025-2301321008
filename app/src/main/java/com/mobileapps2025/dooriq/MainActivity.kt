package com.mobileapps2025.dooriq

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mobileapps2025.dooriq.ui.screens.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()

            NavHost(
                navController = navController,
                startDestination = "role_selection"
            ) {
                composable("role_selection") { RoleSelectionScreen { role ->
                    when (role) {
                        UserRole.STUDENT -> navController.navigate("student")
                        UserRole.ADMIN -> navController.navigate("admin")
                    }
                } }

                composable("student") { StudentScreen { navController.navigate("qrscanner") } }
                composable("admin") { AdminScreen() }
                composable("qrscanner") { QRScannerScreen { navController.popBackStack() } }
            }
        }
    }
}