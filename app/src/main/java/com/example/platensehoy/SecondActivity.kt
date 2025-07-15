package com.example.platensehoy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight
import com.example.platensehoy.ui.theme.MarronPlatense

class SecondActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val mensaje = intent.getStringExtra("mensaje") ?: "Sin datos"

        setContent {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = Color.White
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "PlatenseHOY",
                        fontSize = 26.sp,
                        fontWeight = FontWeight.Bold,
                        color = MarronPlatense
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = mensaje,
                        fontSize = 18.sp,
                        color = Color.DarkGray
                    )
                    Spacer(modifier = Modifier.height(24.dp))
                    Button(onClick = { finish() }) {
                        Text("Volver")
                    }
                }
            }
        }
    }
}
