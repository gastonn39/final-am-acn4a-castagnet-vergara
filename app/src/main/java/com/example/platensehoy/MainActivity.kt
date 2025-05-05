package com.example.platensehoy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.material3.HorizontalDivider


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PlatenseHOYTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = Color.White) {
                    PantallaPrincipal()
                }
            }
        }
    }
}

@Composable
fun PantallaPrincipal() {
    val noticias = listOf(
        "Platense se quedó sin nada en el Bosque y jugará los octavos de final contra Racing.",
        "El básquet consigue una gran victoria contra Boca por 96 a 94.",
        "El equipo entrena en el Ciudad de Vicente López de cara al partido contra Racing.",
        "Oscar Salomón lesionado y se perderá lo que queda del campeonato."
    )

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        item {
            // Encabezado
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFF4E3629))
                    .padding(vertical = 16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "PlatenseHOY",
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            }

            // Menú horizontal fijo
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFF4E3629))
                    .padding(vertical = 8.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                val secciones = listOf("Últimas noticias", "Fútbol", "Básquet", "Login")
                secciones.forEach { seccion ->
                    Text(
                        text = seccion,
                        color = Color.White,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 14.sp
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Imagen destacada
            Image(
                painter = painterResource(id = R.drawable.final_gyc_cap),
                contentDescription = "Imagen del partido",
                modifier = Modifier
                    .height(220.dp)
                    .fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(12.dp))

            // Título de la noticia principal
            Text(
                text = noticias[0],
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF4E3629),
                modifier = Modifier.padding(horizontal = 16.dp)
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Subtítulo
            Text(
                text = "Análisis del partido",
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color(0xFF4E3629),
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 4.dp)
            )


            Text(
                text = "Si bien Platense tuvo las jugadas más claras, en la última del partido lo perdió contra el Lobo con un gol de cabeza de Nicolás Garayalde. " +
                        "Durante gran parte del encuentro, el Calamar mostró orden y actitud ofensiva, pero le faltó precisión en los últimos metros. " +
                        "El mediocampo se vio superado por momentos y la línea de fondo cometió errores clave. " +
                        "Puntos altos en Platense: Juan Pablo Pignani y Vázquez. En cambio, quienes anduvieron flojos fueron el doble 5 (Baldassarra y Juárez), el lateral Silva y los delanteros Orsini y Lotti.",
                fontSize = 16.sp,
                color = Color.DarkGray,
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
            )


            HorizontalDivider(
                color = Color.LightGray,
                thickness = 1.dp,
                modifier = Modifier.padding(vertical = 12.dp)
            )



            Text(
                text = "Otras noticias",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF4E3629),
                modifier = Modifier.padding(horizontal = 16.dp)
            )
        }


        items(noticias.drop(1)) { noticia ->
            Text(
                text = "• $noticia",
                fontSize = 16.sp,
                color = Color(0xFF4E3629),
                modifier = Modifier.padding(horizontal = 24.dp, vertical = 4.dp)
            )
        }
    }
}
