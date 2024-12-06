
package com.example.planetapp.ui.theme.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.example.planetapp.models.Planet
import com.example.planetapp.models.planetList
import com.example.planetapp.ui.theme.components.TopAppBarWithMenu
import com.example.planetapp.ui.theme.components.PlanetListItem

@ExperimentalMaterial3Api
@Composable
fun HomeScreen(
    onPlanetSelected: (Planet) -> Unit,
    onSettingsClick: () -> Unit,
    onHelpClick: () -> Unit
) {
    var searchQuery by remember { mutableStateOf("") }
    val filteredPlanets by remember(searchQuery) {
        derivedStateOf { planetList.filter { it.name.contains(searchQuery, ignoreCase = true) } }
    }
    val recentSearches = remember { mutableStateListOf<Planet>() }

    Scaffold(
        topBar = {
            TopAppBarWithMenu(
                onSettingsClick = onSettingsClick,
                onHelpClick = onHelpClick
            )
        }
    ) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
            SearchBar(
                query = searchQuery,
                onQueryChange = { searchQuery = it }
            )
            RecentSearches(
                recentSearches = recentSearches,
                onPlanetSelected = onPlanetSelected
            )
            PlanetList(
                planets = filteredPlanets,
                onPlanetSelected = { selectedPlanet ->
                    if (!recentSearches.contains(selectedPlanet)) {
                        recentSearches.add(0, selectedPlanet)
                    }
                    onPlanetSelected(selectedPlanet)
                },
                onFavoriteToggle = { favoritePlanet ->
                    favoritePlanet.isFavorite = !favoritePlanet.isFavorite
                }
            )
        }
    }
}

@Composable
private fun SearchBar(query: String, onQueryChange: (String) -> Unit) {
    TextField(
        value = query,
        onValueChange = onQueryChange,
        label = { Text("Pesquisar") },
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    )
}

@Composable
private fun RecentSearches(
    recentSearches: List<Planet>,
    onPlanetSelected: (Planet) -> Unit
) {
    LazyRow(
        modifier = Modifier.padding(vertical = 8.dp, horizontal = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(recentSearches) { planet ->
            Button(onClick = { onPlanetSelected(planet) }) {
                Text(planet.name)
            }
        }
    }
}

@Composable
private fun PlanetList(
    planets: List<Planet>,
    onPlanetSelected: (Planet) -> Unit,
    onFavoriteToggle: (Planet) -> Unit
) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier.padding(horizontal = 8.dp)
    ) {
        items(planets) { planet ->
            PlanetListItem(
                planet = planet,
                onPlanetSelected = onPlanetSelected,
                onFavoriteToggle = onFavoriteToggle
            )
        }
    }
}
