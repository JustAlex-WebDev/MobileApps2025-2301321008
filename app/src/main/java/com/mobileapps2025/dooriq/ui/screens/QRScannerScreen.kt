package com.mobileapps2025.dooriq.ui.screens

import android.graphics.BitmapFactory
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.res.painterResource
import com.google.mlkit.vision.barcode.BarcodeScanning
import com.google.mlkit.vision.common.InputImage
import com.mobileapps2025.dooriq.R

@Composable
fun QRScannerScreen(
    onScanResult: (String) -> Unit
) {
    val context = LocalContext.current

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.qr_test),
            contentDescription = "QR Test Image",
            modifier = Modifier.size(250.dp).padding(16.dp)
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = {
            val bitmap = BitmapFactory.decodeResource(context.resources, R.drawable.qr_test)
            val image = InputImage.fromBitmap(bitmap, 0)
            val scanner = BarcodeScanning.getClient()

            scanner.process(image)
                .addOnSuccessListener { barcodes ->
                    barcodes.firstOrNull()?.rawValue?.let { value ->
                        onScanResult(value)
                    }
                }
        }) { Text("Scan This Image") }
    }
}