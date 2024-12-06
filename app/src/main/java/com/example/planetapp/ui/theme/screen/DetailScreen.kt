package com.example.planetapp.ui.theme.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.planetapp.models.Planet

@ExperimentalMaterial3Api
@Composable
fun DetailsScreen(planet: Planet) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = planet.name, style = MaterialTheme.typography.titleLarge) }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp)
        ) {
            PlanetImage(planet)
            Spacer(modifier = Modifier.height(16.dp))
            InfoCard(
                title = "Informações Gerais",
                content = {
                    InfoText(label = "Tipo", value = planet.type)
                    InfoText(label = "Galáxia", value = planet.galaxy)
                    InfoText(label = "Distância do Sol", value = planet.distanceFromSun)
                    InfoText(label = "Diâmetro", value = planet.diameter)
                }
            )
            Spacer(modifier = Modifier.height(16.dp))
            InfoCard(
                title = "Características",
                containerColor = MaterialTheme.colorScheme.surfaceVariant,
                content = {
                    Text(
                        text = planet.characteristics,
                        style = MaterialTheme.typography.bodyMedium,
                        lineHeight = 20.sp
                    )
                }
            )
        }
    }
}

@Composable
private fun PlanetImage(planet: Planet) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(240.dp),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = planet.imageRes),
            contentDescription = "Imagem de ${planet.name}",
            modifier = Modifier
                .size(200.dp)
                .clip(CircleShape)
        )
    }
}

@Composable
private fun InfoCard(
    title: String,
    containerColor: Color = MaterialTheme.colorScheme.surface,
    content: @Composable ColumnScope.() -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = containerColor)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = title,
                style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                color = MaterialTheme.colorScheme.primary
            )
            Spacer(modifier = Modifier.height(8.dp))
            content()
        }
    }
}

@Composable
private fun InfoText(label: String, value: String) {
    Text(
        text = "$label: $value",
        style = MaterialTheme.typography.bodyLarge
    )
}
