package com.example.platensehoy

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight
import com.example.platensehoy.ui.theme.MarronPlatense
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ListenerRegistration
import android.widget.Toast

@Composable
fun Futbol(onNavigate: (String) -> Unit) {
    val context = LocalContext.current
    val db = FirebaseFirestore.getInstance()
    val comentarios = remember { mutableStateListOf<String>() }
    var nuevoComentario by remember { mutableStateOf("") }

    // 🔁 Escuchar cambios en Firestore
    DisposableEffect(Unit) {
        val listener: ListenerRegistration = db.collection("comentarios_futbol")
            .addSnapshotListener { snapshot, error ->
                if (error == null && snapshot != null) {
                    comentarios.clear()
                    for (doc in snapshot.documents) {
                        doc.getString("texto")?.let { comentarios.add(it) }
                    }
                }
            }

        onDispose { listener.remove() }
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        item {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(MarronPlatense)
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

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(MarronPlatense)
                    .padding(vertical = 8.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                val secciones = listOf("Últimas noticias", "Fútbol", "Básquet", "Login")
                secciones.forEach { seccion ->
                    Text(
                        text = seccion,
                        color = Color.White,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 14.sp,
                        modifier = Modifier.clickable {
                            when (seccion) {
                                "Últimas noticias" -> onNavigate("home")
                                "Fútbol" -> onNavigate("futbol")
                                "Básquet" -> onNavigate("basquet")
                                "Login" -> onNavigate("login")
                            }
                        }
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Banner corregido
            Image(
                painter = painterResource(id = R.drawable.plantel),
                contentDescription = "Entrenamiento",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(220.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "El equipo se entrena en Ciudad de Vicente López",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = MarronPlatense,
                modifier = Modifier.padding(horizontal = 16.dp)
            )

            Text(
                text = "El equipo ya se entrena pensando en Racing, y no hay lluvia que lo detenga...",
                fontSize = 16.sp,
                color = Color.DarkGray,
                modifier = Modifier.padding(16.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            Image(
                painter = painterResource(id = R.drawable.salomon),
                contentDescription = "Lesión de Salomón",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(220.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Oscar Salomón se pierde lo que queda del torneo",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = MarronPlatense,
                modifier = Modifier.padding(horizontal = 16.dp)
            )

            Text(
                text = "El defensor sufrió un desgarro tipo 2 que lo mantendrá alejado...",
                fontSize = 16.sp,
                color = Color.DarkGray,
                modifier = Modifier.padding(16.dp)
            )

            Spacer(modifier = Modifier.height(32.dp))

            Text(
                text = "Comentarios del partido",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = MarronPlatense,
                modifier = Modifier.padding(horizontal = 16.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = nuevoComentario,
                onValueChange = { nuevoComentario = it },
                label = { Text("Dejá tu comentario") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = {
                    if (nuevoComentario.isNotBlank()) {
                        db.collection("comentarios_futbol").add(mapOf("texto" to nuevoComentario))
                            .addOnSuccessListener {
                                nuevoComentario = ""
                                Toast.makeText(context, "Comentario agregado", Toast.LENGTH_SHORT).show()
                            }
                            .addOnFailureListener {
                                Toast.makeText(context, "Error: ${it.message}", Toast.LENGTH_LONG).show()
                            }
                    }
                },
                modifier = Modifier.padding(horizontal = 16.dp)
            ) {
                Text("Agregar comentario")
            }

            Spacer(modifier = Modifier.height(16.dp))

            comentarios.forEach { comentario ->
                Text(
                    text = "• $comentario",
                    fontSize = 16.sp,
                    modifier = Modifier.padding(horizontal = 24.dp, vertical = 4.dp)
                )
            }

            Spacer(modifier = Modifier.height(32.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Button(onClick = { onNavigate("home") }) {
                    Text("Volver")
                }
            }

            Spacer(modifier = Modifier.height(32.dp))
        }
    }
}
