package com.example.platensehoy

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight
import com.example.platensehoy.ui.theme.MarronPlatense
import com.example.platensehoy.R

@Composable
fun Futbol(onBack: () -> Unit) {
    val comentarios = remember { mutableStateListOf<String>() }
    var nuevoComentario by remember { mutableStateOf("") }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(dimensionResource(R.dimen.padding_general))
    ) {
        item {
            Text(
                text = "FÚTBOL",
                fontSize = dimensionResource(R.dimen.text_size_titulo).value.sp,
                fontWeight = FontWeight.Bold,
                color = MarronPlatense
            )

            Spacer(modifier = Modifier.height(dimensionResource(R.dimen.margin_vertical)))

            Image(
                painter = painterResource(id = R.drawable.plantel),
                contentDescription = "Entrenamiento",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            )

            Spacer(modifier = Modifier.height(dimensionResource(R.dimen.espaciado)))

            Text(
                text = "El equipo se entrena en Ciudad de Vicente López",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = MarronPlatense
            )

            Text(
                text = "El equipo ya se entrena pensando en Racing, y no hay lluvia que lo detenga...",
                fontSize = 16.sp,
                color = Color.DarkGray,
                modifier = Modifier.padding(vertical = 8.dp)
            )

            Spacer(modifier = Modifier.height(dimensionResource(R.dimen.margin_vertical)))

            Image(
                painter = painterResource(id = R.drawable.salomon),
                contentDescription = "Lesión de Salomón",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            )

            Spacer(modifier = Modifier.height(dimensionResource(R.dimen.espaciado)))

            Text(
                text = "Oscar Salomón se pierde lo que queda del torneo",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = MarronPlatense
            )

            Text(
                text = "El defensor sufrió un desgarro tipo 2 que lo mantendrá alejado...",
                fontSize = 16.sp,
                color = Color.DarkGray,
                modifier = Modifier.padding(vertical = 8.dp)
            )

            Spacer(modifier = Modifier.height(32.dp))

            // ----------------------------
            // SECCIÓN DE COMENTARIOS
            // ----------------------------
            Text(
                text = "Comentarios del partido",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = MarronPlatense
            )

            Spacer(modifier = Modifier.height(dimensionResource(R.dimen.espaciado)))

            OutlinedTextField(
                value = nuevoComentario,
                onValueChange = { nuevoComentario = it },
                label = { Text("Dejá tu comentario") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(dimensionResource(R.dimen.espaciado)))

            Button(
                onClick = {
                    if (nuevoComentario.isNotBlank()) {
                        comentarios.add(nuevoComentario)
                        nuevoComentario = ""
                    }
                }
            ) {
                Text("Agregar comentario")
            }

            Spacer(modifier = Modifier.height(dimensionResource(R.dimen.margin_vertical)))

            comentarios.forEach { comentario ->
                Text(
                    text = "• $comentario",
                    fontSize = dimensionResource(R.dimen.text_size_normal).value.sp,
                    modifier = Modifier.padding(vertical = 4.dp)
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            // ✅ BOTÓN VOLVER CENTRADO
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Button(onClick = onBack) {
                    Text("Volver")
                }
            }

            Spacer(modifier = Modifier.height(32.dp))
        }
    }
}
