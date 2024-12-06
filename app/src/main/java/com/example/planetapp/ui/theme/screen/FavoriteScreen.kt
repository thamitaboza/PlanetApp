
package com.example.planetapp.ui.theme.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.planetapp.models.Planet
import com.example.planetapp.models.planetList
import com.example.planetapp.ui.theme.components.PlanetListItem

@ExperimentalMaterial3Api
@Composable
fun FavoritesScreen(
    onPlanetSelected: (Planet) -> Unit,
    onFavoriteToggle: (Planet) -> Unit
) {
    val favoritePlanets = planetList.filter { it.isFavorite }

    Scaffold(
        topBar = { FavoritesTopBar() }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentAlignment = Alignment.Center
        ) {
            if (favoritePlanets.isEmpty()) {
                EmptyFavoritesMessage()
            } else {
                FavoritesList(
                    favoritePlanets = favoritePlanets,
                    onPlanetSelected = onPlanetSelected,
                    onFavoriteToggle = onFavoriteToggle
                )
            }
        }
    }
}

@Composable
private fun FavoritesTopBar() {
    TopAppBar(
        title = {
            Text(
                text = "Favoritos",
                style = MaterialTheme.typography.titleLarge
            )
        }
    )
}

@Composable
private fun EmptyFavoritesMessage() {
    Text(
        text = "Você ainda não adicionou favoritos.",
        style = MaterialTheme.typography.titleMedium,
        textAlign = TextAlign.Center,
        color = MaterialTheme.colorScheme.onSurfaceVariant
    )
}

@Composable
private fun FavoritesList(
    favoritePlanets: List<Planet>,
    onPlanetSelected: (Planet) -> Unit,
    onFavoriteToggle: (Planet) -> Unit
) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 8.dp)
    ) {
        items(favoritePlanets) { planet ->
            PlanetListItem(
                planet = planet,
                onPlanetSelected = onPlanetSelected,
                onFavoriteToggle = onFavoriteToggle
            )
        }
    }
}
