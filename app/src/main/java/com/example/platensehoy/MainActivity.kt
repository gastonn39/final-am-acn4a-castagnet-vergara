package com.example.platensehoy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.platensehoy.ui.theme.PlatenseHOYTheme
import com.example.platensehoy.Futbol


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PlatenseHOYTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = Color.White) {
                    AppController()
                }
            }
        }
    }
}

@Composable
fun AppController() {
    var currentScreen by remember { mutableStateOf("home") }

    when (currentScreen) {
        "home" -> PantallaPrincipal(onSeccionClick = { seccion ->
            if (seccion == "Fútbol") {
                currentScreen = "futbol"
            }
        })
        "futbol" -> Futbol(onBack = { currentScreen = "home" })

    }
}

@Composable
fun PantallaPrincipal(onSeccionClick: (String) -> Unit) {
    val noticias = listOf(
        stringResource(R.string.noticia_principal),
        stringResource(R.string.seccion_basquet) + " consigue una gran victoria contra Boca por 96 a 94.",
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
                    text = stringResource(R.string.app_name),
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            }

            // Menú horizontal fijo clickeable
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFF4E3629))
                    .padding(vertical = 8.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                val secciones = listOf(
                    stringResource(R.string.seccion_ultimas),
                    "Fútbol",
                    stringResource(R.string.seccion_basquet),
                    stringResource(R.string.seccion_login)
                )
                secciones.forEach { seccion ->
                    Text(
                        text = seccion,
                        color = Color.White,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 14.sp,
                        modifier = Modifier.clickable { onSeccionClick(seccion) }
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
                text = stringResource(R.string.subtitulo_principal),
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color(0xFF4E3629),
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 4.dp)
            )

            // Texto extendido
            Text(
                text = stringResource(R.string.texto_principal),
                fontSize = 16.sp,
                color = Color.DarkGray,
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
            )

            // Línea divisoria
            HorizontalDivider(
                color = Color(0xFF4E3629),
                thickness = 1.dp,
                modifier = Modifier
                    .padding(horizontal = 16.dp, vertical = 8.dp)
            )

            // Sección de otras noticias
            Text(
                text = stringResource(R.string.otras_noticias),
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF4E3629),
                modifier = Modifier.padding(horizontal = 16.dp)
            )
        }

        // Lista de otras noticias
        items(noticias.drop(1)) { noticia ->
            Text(
                text = "• $noticia",
                fontSize = 16.sp,
                color = Color(0xFF4E3629),
                modifier = Modifier.padding(horizontal = 24.dp, vertical = 4.dp)
            )
        }

        // Espacio para scroll
        item {
            Spacer(modifier = Modifier.height(100.dp))
        }
    }
}

