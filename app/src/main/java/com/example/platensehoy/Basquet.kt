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
import com.example.platensehoy.ui.theme.MarronPlatense
import com.example.platensehoy.R

@Composable
fun Basquet(onBack: () -> Unit) {
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
                        modifier = Modifier.clickable { onBack() }
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Image(
                painter = painterResource(id = R.drawable.basquetvsboca),
                contentDescription = "Imagen partido vs Boca",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .padding(horizontal = 16.dp)
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Platense le gana a Boca 76 a 67",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = MarronPlatense,
                modifier = Modifier.padding(horizontal = 16.dp)
            )

            Text(
                text = "En un partido muy duro, Platense superó a Boca con cuatro triples de Vázquez y un cierre de partido muy sólido en defensa.",
                fontSize = 16.sp,
                color = Color.DarkGray,
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
            )

            Spacer(modifier = Modifier.height(24.dp))

            Image(
                painter = painterResource(id = R.drawable.basquetimagen),
                contentDescription = "Imagen general básquet",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .padding(horizontal = 16.dp)
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "El Calamar busca meterse en los playoffs",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = MarronPlatense,
                modifier = Modifier.padding(horizontal = 16.dp)
            )

            Text(
                text = "Con esta victoria, Platense queda a un paso de la clasificación. El próximo partido será frente a Obras Sanitarias, donde buscará consolidar su juego defensivo.",
                fontSize = 16.sp,
                color = Color.DarkGray,
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
            )

            Spacer(modifier = Modifier.height(32.dp))

            Text(
                text = "Calendario de próximos partidos",
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold,
                color = MarronPlatense,
                modifier = Modifier.padding(horizontal = 16.dp)
            )

            val calendario = listOf(
                "Platense vs Obras Sanitarias - Sábado 18:00hs",
                "Platense vs Instituto - Miércoles 21:00hs",
                "Platense vs San Lorenzo - Domingo 19:30hs"
            )

            calendario.forEach { partido ->
                Text(
                    text = "• $partido",
                    fontSize = 16.sp,
                    color = Color.Black,
                    modifier = Modifier.padding(horizontal = 24.dp, vertical = 4.dp)
                )
            }

            Spacer(modifier = Modifier.height(32.dp))

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
