package com.example.platensehoy

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.platensehoy.ui.theme.MarronPlatense
import com.example.platensehoy.R

@Composable
fun PantallaLoginScreen(onBack: () -> Unit, onNavigate: (String) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        // Encabezado
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
                color = Color.White
            )
        }

        // Menú
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

        Spacer(modifier = Modifier.height(32.dp))

        // Formulario login
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Iniciar Sesión", fontSize = 24.sp, color = MarronPlatense)

            Spacer(modifier = Modifier.height(24.dp))

            var usuario by remember { mutableStateOf("") }
            var contraseña by remember { mutableStateOf("") }
            var error by remember { mutableStateOf(false) }

            OutlinedTextField(
                value = usuario,
                onValueChange = { usuario = it },
                label = { Text("Usuario") },
                isError = error
            )

            Spacer(modifier = Modifier.height(12.dp))

            OutlinedTextField(
                value = contraseña,
                onValueChange = { contraseña = it },
                label = { Text("Contraseña") },
                visualTransformation = PasswordVisualTransformation(),
                isError = error
            )

            Spacer(modifier = Modifier.height(16.dp))

            Button(onClick = {
                error = !(usuario == "platense" && contraseña == "calamar")
            }) {
                Text("Ingresar")
            }

            if (error) {
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Usuario o contraseña incorrectos",
                    color = Color.Red,
                    fontSize = 14.sp
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            TextButton(onClick = onBack) {
                Text("Volver al inicio")
            }
        }
    }
}
