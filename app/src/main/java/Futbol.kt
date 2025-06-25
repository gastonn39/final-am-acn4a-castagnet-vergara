package com.example.platensehoy

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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.platensehoy.ui.theme.MarronPlatense
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ListenerRegistration
import java.text.SimpleDateFormat
import java.util.*

@Composable
fun Futbol(onNavigate: (String) -> Unit) {
    val db = FirebaseFirestore.getInstance()
    val comentarios = remember { mutableStateListOf<Pair<String, String>>() }
    var nuevoComentario by remember { mutableStateOf("") }
    val sdf = remember { SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.getDefault()) }

    DisposableEffect(Unit) {
        val listener: ListenerRegistration = db.collection("comentarios_futbol")
            .addSnapshotListener { snapshot, error ->
                if (error == null && snapshot != null) {
                    comentarios.clear()
                    for (doc in snapshot.documents) {
                        val texto = doc.getString("texto") ?: continue
                        val timestamp = doc.getTimestamp("fecha")?.toDate()?.let { sdf.format(it) } ?: "Sin fecha"
                        comentarios.add(texto to timestamp)
                    }
                }
            }
        onDispose { listener.remove() }
    }

    Column(modifier = Modifier.fillMaxSize().background(Color.White)) {
        Column(
            modifier = Modifier.fillMaxWidth().background(MarronPlatense).padding(vertical = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("PlatenseHOY", fontSize = 32.sp, color = Color.White)
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
                    fontSize = 14.sp,
                    modifier = Modifier.clickable {
                        when (seccion) {
                            "Fútbol" -> onNavigate("futbol")
                            "Básquet" -> onNavigate("basquet")
                            "Últimas noticias" -> onNavigate("home")
                        }
                    }
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn(modifier = Modifier.padding(horizontal = 16.dp)) {

            // 🟤 Noticias destacadas (nueva arriba)
            items(
                listOf(
                    Triple("El campeón entrena en Mar del Plata de cara a lo que se le viene", R.drawable.mdp,
                        "El plantel sin bajas hasta el momento se entrena en la ciudad de Mar del Plata realizando actividades de pretemporada, sin sufrir bajas y con rumores para este mercado de pases, el campeón piensa en el la Re-Copa y en la liga clausura"),
                    Triple("Platense campeón", R.drawable.campeones,
                        "El equipo de la dupla logró ganarle a Huracán 1x0 en el estadio Madre de Ciudades y se consagró campeón por primera vez en su historia. Más de 14.000 mil hinchas calamares se hicieron presentes para un hito histórico del club."),
                    Triple("Platense jugará la Libertadores", R.drawable.libertadores,
                        "Al ser campeón, el equipo de Vicente López se asegura un lugar para la próxima Copa Libertadores, copa que también jugará por primera vez en su historia. Ya comenzaron los trabajos preparativos para dejar el estadio en condiciones y cumplir con las normativas Conmebol."),
                    Triple("Platense jugará una nueva final", R.drawable.contracasla,
                        "El equipo de la dupla logró ganar 1 a 0 en el Pedro Bidegain con gol de Franco Zapiola y jugará su segunda final en menos de dos años."),
                    Triple("Platense da el batacazo y le gana a River de visitante", R.drawable.contrariver,
                        "Después de un polémico partido y arbitraje de Yael Falcón Pérez, Platense se logró quedar con el partido por penales y jugará la semifinal contra CASLA. El equipo calamar fue perjudicado sistemáticamente por los fallos del árbitro, pero aun así logró sobreponerse y ganar un partido prácticamente imposible.")
                )
            ) { (titulo, imagen, cuerpo) ->
                Image(
                    painter = painterResource(id = imagen),
                    contentDescription = titulo,
                    modifier = Modifier.fillMaxWidth().height(200.dp),
                    contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(titulo, fontSize = 18.sp, fontWeight = FontWeight.Bold, color = MarronPlatense)
                Text(cuerpo, fontSize = 14.sp, color = Color.DarkGray)
                Spacer(modifier = Modifier.height(16.dp))
            }

            // 🟤 Noticias clásicas abajo
            item {
                Image(
                    painter = painterResource(id = R.drawable.plantel),
                    contentDescription = "Entrenamiento",
                    modifier = Modifier.fillMaxWidth().height(200.dp),
                    contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text("El equipo se entrena en Ciudad de Vicente López", fontSize = 18.sp, fontWeight = FontWeight.Bold, color = MarronPlatense)
                Text("El equipo se entrena pensando en Racing y no hay lluvias que lo detengan...", fontSize = 14.sp, color = Color.DarkGray)
                Spacer(modifier = Modifier.height(16.dp))
            }

            item {
                Image(
                    painter = painterResource(id = R.drawable.salomon),
                    contentDescription = "Lesión de Salomón",
                    modifier = Modifier.fillMaxWidth().height(200.dp),
                    contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text("Oscar Salomón se pierde lo que queda del torneo", fontSize = 18.sp, fontWeight = FontWeight.Bold, color = MarronPlatense)
                Text("El defensor sufrió un desgarro tipo 2 que lo mantendrá alejado...", fontSize = 14.sp, color = Color.DarkGray)
                Spacer(modifier = Modifier.height(16.dp))
            }

            // 💬 Comentarios
            item {
                Text("Comentarios del partido", fontSize = 18.sp, color = MarronPlatense)
                Spacer(modifier = Modifier.height(8.dp))
            }

            items(comentarios) { (texto, fecha) ->
                Text("• $texto", fontSize = 14.sp, color = Color.Black)
                Text(fecha, fontSize = 12.sp, color = Color.Gray, modifier = Modifier.padding(start = 8.dp, bottom = 8.dp))
            }

            item {
                OutlinedTextField(
                    value = nuevoComentario,
                    onValueChange = { nuevoComentario = it },
                    label = { Text("Dejá tu comentario") },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(8.dp))
                Button(onClick = {
                    if (nuevoComentario.isNotBlank()) {
                        db.collection("comentarios_futbol").add(
                            mapOf(
                                "texto" to nuevoComentario,
                                "fecha" to Date()
                            )
                        )
                        nuevoComentario = ""
                    }
                }) {
                    Text("Comentar")
                }
                Spacer(modifier = Modifier.height(80.dp))
            }
        }
    }
}

