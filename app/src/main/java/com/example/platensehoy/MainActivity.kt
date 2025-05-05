package com.example.platensehoy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.platensehoy.ui.theme.PlatenseHOYTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = Color.White) {
                    PantallaPrincipal()
                }
            }
        }
    }
}

@Composable
fun PantallaPrincipal() {
    var noticias by remember { mutableStateOf(
        listOf(
            "Primer equipo entrena en Vicente López",
            "Platense se quedó sin nada en el Bosque y jugará los octavos de final contra Racing"
        )
    ) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "PlatenseHOY",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF4E3629) // Marrón Platense
        )

        Spacer(modifier = Modifier.height(16.dp))

        Image(
            painter = painterResource(id = R.drawable.final_gyc_cap),
            contentDescription = "Imagen del partido Gimnasia vs Platense",
            modifier = Modifier
                .height(220.dp)
                .fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = "Platense se quedó sin nada en el Bosque y jugará los octavos de final contra Racing.",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF4E3629),
            modifier = Modifier.padding(bottom = 8.dp)
        )

        Text(
            text = "Si bien Platense tuvo las jugadas más claras, en la última del partido lo perdió contra el Lobo con un gol de cabeza de Nicolás Garayalde. " +
                    "Puntos altos en Platense: Juan Pablo Pignani y Vázquez. Quienes anduvieron flojos: el doble 5 (Baldassarra y Juárez), el tres Silva y los delanteros Orsini y Lotti.",
            fontSize = 16.sp,
            color = Color.DarkGray,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Button(onClick = {
            noticias = noticias + "Nueva noticia agregada"
        }) {
            Text("Agregar Noticia")
        }

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn {
            items(noticias) { noticia ->
                Text(
                    text = "• $noticia",
                    fontSize = 16.sp,
                    modifier = Modifier.padding(4.dp)
                )
            }
        }
    }
}
