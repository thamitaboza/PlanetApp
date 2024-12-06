package com.example.planetapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.*
import androidx.compose.runtime.*
import com.example.planetapp.navigation.NavGraph
import com.example.planetapp.ui.theme.PlanetAppTheme

@ExperimentalMaterial3Api
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PlanetApp()
        }
    }
}

@ExperimentalMaterial3Api
@Composable
fun PlanetApp() {
    var showSettingsDialog by remember { mutableStateOf(false) }
    var showHelpDialog by remember { mutableStateOf(false) }

    PlanetAppTheme {
        // Navegação principal
        NavGraph(
            onSettingsClick = { showSettingsDialog = true },
            onHelpClick = { showHelpDialog = true }
        )

        // Diálogo de Configurações
        if (showSettingsDialog) {
            AppDialog(
                title = "Configurações",
                message = "Aqui você pode configurar as preferências do aplicativo.",
                onDismiss = { showSettingsDialog = false }
            )
        }

        // Diálogo de Ajuda
        if (showHelpDialog) {
            AppDialog(
                title = "Ajuda",
                message = "Aqui você encontra informações para usar o aplicativo.",
                onDismiss = { showHelpDialog = false }
            )
        }
    }
}

@Composable
fun AppDialog(
    title: String,
    message: String,
    onDismiss: () -> Unit
) {
    AlertDialog(
        onDismissRequest = onDismiss,
        confirmButton = {
            TextButton(onClick = onDismiss) {
                Text("OK")
            }
        },
        title = { Text(title) },
        text = { Text(message) }
    )
}
