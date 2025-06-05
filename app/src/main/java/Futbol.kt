package com.example.platensehoy

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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

@Composable
fun Futbol(onBack: () -> Unit) {
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
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "PlatenseHOY",
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            }

            Text(
                text = "FÚTBOL",
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                color = MarronPlatense,
                modifier = Modifier.padding(top = 16.dp, bottom = 8.dp).align(Alignment.CenterHorizontally)
            )

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
                color = MarronPlatense,
                modifier = Modifier.padding(horizontal = 16.dp)
            )

            Text(
                text = "El equipo ya se entrena pensando en Racing...", // Reemplazar por stringResource
                fontSize = 16.sp,
                color = Color.DarkGray,
                modifier = Modifier.padding(16.dp)
            )

            Image(
                painter = painterResource(id = R.drawable.salomon),
                contentDescription = "Lesión de Salomón",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .padding(horizontal = 16.dp)
            )

            Text(
                text = "Oscar Salomón se pierde el torneo",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = MarronPlatense,
                modifier = Modifier.padding(horizontal = 16.dp)
            )

            Text(
                text = "El defensor sufrió un desgarro...", // Reemplazar por stringResource
                fontSize = 16.sp,
                color = Color.DarkGray,
                modifier = Modifier.padding(16.dp)
            )

            Button(
                onClick = onBack,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            ) {
                Text("Volver")
            }
        }
    }
}
