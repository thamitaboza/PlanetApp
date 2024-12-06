
package com.example.planetapp.ui.theme.components

import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow

@ExperimentalMaterial3Api
@Composable
fun TopAppBarWithMenu(
    onSettingsClick: () -> Unit,
    onHelpClick: () -> Unit
) {
    var isMenuExpanded by remember { mutableStateOf(false) }

    TopAppBar(
        title = { AppBarTitle() },
        actions = { AppBarMenu(isMenuExpanded, onSettingsClick, onHelpClick) { isMenuExpanded = it } },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary,
            titleContentColor = MaterialTheme.colorScheme.onPrimary,
            actionIconContentColor = MaterialTheme.colorScheme.onPrimary
        )
    )
}

@Composable
private fun AppBarTitle() {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Text(
            text = "PlanetApp",
            style = MaterialTheme.typography.titleLarge,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }
}

@Composable
private fun AppBarMenu(
    isMenuExpanded: Boolean,
    onSettingsClick: () -> Unit,
    onHelpClick: () -> Unit,
    onMenuStateChange: (Boolean) -> Unit
) {
    IconButton(onClick = { onMenuStateChange(true) }) {
        Icon(
            imageVector = Icons.Default.MoreVert,
            contentDescription = "Menu"
        )
    }
    DropdownMenu(
        expanded = isMenuExpanded,
        onDismissRequest = { onMenuStateChange(false) }
    ) {
        DropdownMenuItem(
            text = { Text("Configurações") },
            onClick = {
                onMenuStateChange(false)
                onSettingsClick()
            }
        )
        DropdownMenuItem(
            text = { Text("Ajuda") },
            onClick = {
                onMenuStateChange(false)
                onHelpClick()
            }
        )
    }
}
