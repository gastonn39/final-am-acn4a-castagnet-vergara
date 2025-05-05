package com.example.platensehoy

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.material3.HorizontalDivider

@Composable
fun PantallaFutbol(onBack: () -> Unit) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        item {
            // Header fijo (PlatenseHOY + menú)
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

            // Título principal
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "FÚTBOL",
                    fontSize = 39.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF4E3629)
                )
            }

            // Primera sección
            Image(
                painter = painterResource(id = R.drawable.plantel),
                contentDescription = "Entrenamiento",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .padding(horizontal = 16.dp)
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "El equipo se entrena en Ciudad de Vicente López",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF4E3629),
                modifier = Modifier.padding(horizontal = 16.dp)
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = "El equipo ya se entrena pensando en Racing, y no hay lluvia que lo detenga. " +
                        "Con la baja de Salomón, quien se perfila como titular en la zaga central es Juan Pablo Pignani, " +
                        "surgido de las inferiores calamares y de gran desempeño frente a Gimnasia en el Bosque.\n\n" +
                        "Por otro lado, la principal duda está en el ataque: ¿jugarán Lotti y Orsini o ingresará Ronaldo Martínez? " +
                        "El cuerpo técnico es optimista y confía en obtener un triunfo que le permita a Platense avanzar de fase.",
                fontSize = 16.sp,
                color = Color.DarkGray,
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))
            HorizontalDivider(
                color = Color.LightGray,
                thickness = 1.dp,
                modifier = Modifier.padding(vertical = 16.dp, horizontal = 16.dp)
            )

            // Segunda sección
            Image(
                painter = painterResource(id = R.drawable.salomon),
                contentDescription = "Lesión de Salomón",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .padding(horizontal = 16.dp)
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Oscar Salomón se pierde lo que queda del torneo",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF4E3629),
                modifier = Modifier.padding(horizontal = 16.dp)
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = "El defensor sufrió un desgarro tipo 2 que lo mantendrá alejado de las canchas por al menos tres semanas, " +
                        "según informó el cuerpo médico. Su reemplazante será Juan Pablo Pignani, joven central de las inferiores " +
                        "que ya tuvo un buen rendimiento en su última presentación.\n\n" +
                        "La baja de Salomón es sensible para Platense, ya que venía siendo titular tanto en el torneo local " +
                        "como en la Copa Argentina. ¡Le deseamos una pronta recuperación!",
                fontSize = 16.sp,
                color = Color.DarkGray,
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
            )

            Spacer(modifier = Modifier.height(32.dp))

            // Botón para volver
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Button(onClick = onBack) {
                    Text("Volver")
                }
            }
            HorizontalDivider(
                color = Color.LightGray,
                thickness = 1.dp,
                modifier = Modifier.padding(vertical = 16.dp, horizontal = 16.dp)
            )

            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}
