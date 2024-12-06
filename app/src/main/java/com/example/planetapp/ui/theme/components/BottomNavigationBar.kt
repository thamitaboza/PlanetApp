package com.example.planetapp.ui.theme.components


import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.NavDestination.Companion.hierarchy
import com.example.planetapp.navigation.BottomBarScreen

@Composable
fun BottomNavigationBar(navController: NavController) {
    val screens = listOf(BottomBarScreen.Home, BottomBarScreen.Favorites)
    val currentDestination = navController.currentBackStackEntryAsState().value?.destination

    NavigationBar {
        screens.forEach { screen ->
            BottomNavigationItem(
                screen = screen,
                isSelected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
                onClick = {
                    navController.navigate(screen.route) {
                        popUpTo(navController.graph.startDestinationId) { saveState = true }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}

@Composable
private fun NavigationBarItemColors() = NavigationBarItemDefaults.colors(
    selectedIconColor = MaterialTheme.colorScheme.primary,
    unselectedIconColor = MaterialTheme.colorScheme.onSurfaceVariant,
    selectedTextColor = MaterialTheme.colorScheme.primary,
    unselectedTextColor = MaterialTheme.colorScheme.onSurfaceVariant,
    indicatorColor = Color.Transparent
)

@Composable
private fun BottomNavigationItem(
    screen: BottomBarScreen,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    NavigationBarItem(
        selected = isSelected,
        onClick = onClick,
        icon = screen.icon,
        label = { Text(screen.label) },
        colors = NavigationBarItemColors()
    )
}
