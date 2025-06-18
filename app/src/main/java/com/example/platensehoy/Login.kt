package com.example.platensehoy

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.sp
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.dimensionResource
import com.example.platensehoy.ui.theme.MarronPlatense
import com.example.platensehoy.R

@Composable
fun PantallaLoginScreen(onBack: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(dimensionResource(R.dimen.padding_general)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            "Iniciar Sesión",
            fontSize = dimensionResource(R.dimen.text_size_titulo).value.sp,
            color = MarronPlatense
        )

        Spacer(modifier = Modifier.height(dimensionResource(R.dimen.margin_vertical)))

        var usuario by remember { mutableStateOf("") }
        var contraseña by remember { mutableStateOf("") }

        OutlinedTextField(
            value = usuario,
            onValueChange = { usuario = it },
            label = { Text("Usuario") }
        )

        Spacer(modifier = Modifier.height(dimensionResource(R.dimen.espaciado)))

        OutlinedTextField(
            value = contraseña,
            onValueChange = { contraseña = it },
            label = { Text("Contraseña") },
            visualTransformation = PasswordVisualTransformation()
        )

        Spacer(modifier = Modifier.height(dimensionResource(R.dimen.margin_vertical)))

        Button(onClick = {
            // Acción de login
        }) {
            Text("Ingresar")
        }

        Spacer(modifier = Modifier.height(dimensionResource(R.dimen.margin_vertical)))

        TextButton(onClick = onBack) {
            Text("Volver al inicio")
        }
    }
}
