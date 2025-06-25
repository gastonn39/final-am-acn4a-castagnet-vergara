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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.platensehoy.ui.theme.MarronPlatense
import com.example.platensehoy.ui.theme.PlatenseHOYTheme
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PlatenseHOYTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = Color.White) {
                    SplashController()
                }
            }
        }
    }
}

@Composable
fun SplashController() {
    var showSplash by remember { mutableStateOf(true) }
    LaunchedEffect(Unit) {
        delay(2500)
        showSplash = false
    }
    if (showSplash) SplashScreen() else AppController()
}

@Composable
fun SplashScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo_platense),
            contentDescription = "Logo Platense",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
    }
}

@Composable
fun AppController() {
    var currentScreen by remember { mutableStateOf("home") }
    when (currentScreen) {
        "home" -> PantallaPrincipal(onSeccionClick = {
            currentScreen = when (it) {
                "Fútbol" -> "futbol"
                "Básquet" -> "basquet"
                "Login" -> "login"
                else -> "home"
            }
        })
        "futbol" -> Futbol(onNavigate = { currentScreen = it })
        "basquet" -> Basquet(onBack = { currentScreen = "home" })
        "login" -> PantallaLoginScreen(
            onBack = { currentScreen = "home" },
            onNavigate = { currentScreen = it }
        )
    }
}

@Composable
fun PantallaPrincipal(onSeccionClick: (String) -> Unit) {
    val otrasNoticias = listOf(
        "Platense se quedó sin nada en el Bosque",
        "El equipo entrena en el Ciudad de Vicente López de cara al partido contra Racing.",
        "Oscar Salomón lesionado y se perderá lo que queda del campeonato."
    )

    LazyColumn(modifier = Modifier.fillMaxSize().background(Color.White)) {
        item {
            Column(
                modifier = Modifier.fillMaxWidth().background(MarronPlatense).padding(vertical = 16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text("PlatenseHOY", fontSize = 32.sp, fontWeight = FontWeight.Bold, color = Color.White)
            }

            Row(
                modifier = Modifier.fillMaxWidth().background(MarronPlatense).padding(vertical = 8.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                val secciones = listOf("Últimas noticias", "Fútbol", "Básquet", "Login")
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

            Spacer(modifier = Modifier.height(12.dp))
        }

        item {
            NoticiasDestacadas()
        }

        item {
            Text(
                text = stringResource(R.string.otras_noticias),
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = MarronPlatense,
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
            )
        }

        items(otrasNoticias) { noticia ->
            Text(
                text = "• $noticia",
                fontSize = 16.sp,
                color = MarronPlatense,
                modifier = Modifier.padding(horizontal = 24.dp, vertical = 4.dp)
            )
        }

        item {
            Spacer(modifier = Modifier.height(100.dp))
        }
    }
}

@Composable
fun NoticiasDestacadas() {
    val noticias = listOf(
        Triple("Platense campeón", R.drawable.campeones,
            "El equipo de la dupla logró ganarle a Huracán 1x0 en el estadio Madre de Ciudades y se consagró campeón por primera vez en su historia. Más de 14.000 mil hinchas calamares se hicieron presentes para un hito histórico del club."),
        Triple("Platense jugará la Libertadores", R.drawable.libertadores,
            "Al ser campeón, el equipo de Vicente López se asegura un lugar para la próxima Copa Libertadores, copa que también jugará por primera vez en su historia. Ya comenzaron los trabajos preparativos para dejar el estadio en condiciones y cumplir con las normativas Conmebol."),
        Triple("Platense jugará una nueva final", R.drawable.contracasla,
            "El equipo de la dupla logró ganar 1 a 0 en el Pedro Bidegain con gol de Franco Zapiola y jugará su segunda final en menos de dos años."),
        Triple("Platense da el batacazo y le gana a River de visitante", R.drawable.contrariver,
            "Después de un polémico partido y arbitraje de Yael Falcón Pérez, Platense se logró quedar con el partido por penales y jugará la semifinal contra CASLA. El equipo calamar fue perjudicado sistemáticamente por los fallos del árbitro, pero aun así logró sobreponerse y ganar un partido prácticamente imposible.")
    )

    noticias.forEach { (titulo, imagen, cuerpo) ->
        Spacer(modifier = Modifier.height(16.dp))
        Image(
            painter = painterResource(id = imagen),
            contentDescription = titulo,
            modifier = Modifier.fillMaxWidth().height(200.dp),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = titulo,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = MarronPlatense,
            modifier = Modifier.padding(horizontal = 16.dp)
        )
        Text(
            text = cuerpo,
            fontSize = 14.sp,
            color = Color.DarkGray,
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 4.dp)
        )
    }
}
