package com.mobileapps2025.dooriq

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.mobileapps2025.dooriq.ui.theme.DoorIQTheme
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mobileapps2025.dooriq.ui.screens.SecondScreen
import com.mobileapps2025.dooriq.ui.screens.GreetingScreen
import com.mobileapps2025.dooriq.ui.screens.StudentScreen
import com.mobileapps2025.dooriq.ui.screens.QRScannerScreen
import com.mobileapps2025.dooriq.ui.screens.Room

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DoorIQTheme {
                val navController = rememberNavController()
                val sampleRooms = listOf(
                    Room("101", "Math", "Dr. Ivanov", "08:00 - 09:30"),
                    Room("202", "Physics", "Dr. Petrova", "09:45 - 11:15"),
                    Room("303", "History", "Dr. Dimitrov", "11:30 - 13:00")
                )

                NavHost(
                    navController = navController,
                    startDestination = "student"
                ) {
                    composable("student") {
                        StudentScreen(
                            rooms = sampleRooms,
                            onNavigateToScanner = { navController.navigate("qrscanner") } // Navigate to QR scanner
                        )
                    }

                    composable("second") {
                        SecondScreen(
                            onNavigateBack = { navController.popBackStack() }
                        )
                    }

                    composable("qrscanner") {
                        QRScannerScreen(
                            onScanResult = { qrCodeValue ->
                                // Show QR code value or handle it
                                println("Scanned QR: $qrCodeValue")
                                navController.popBackStack() // Return to StudentScreen
                            }
                        )
                    }
                }
            }
        }
    }
}