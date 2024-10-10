package com.example.labortorio06

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.example.labortorio06.ui.theme.Labortorio06Theme
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Labortorio06Theme {
                CustomScaffold()
            }
        }
    }
}
// Función Composable que crea un Scaffold personalizado
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomScaffold() {
    val navController = rememberNavController()
    //Estado para controlar la pantalla actual
    var currentScreen by remember { mutableStateOf("home") }
    var buttonPressCount by remember { mutableStateOf(0) }
    Scaffold(
        // Barra superior
        topBar = {
            TopAppBar(
                navigationIcon = {
                    IconButton(onClick = { /* TODO */ }) {
                        Icon(imageVector = Icons.Rounded.Menu, contentDescription = "Menu")
                    }
                },
                title = { Text(text = "Mi Aplicación") },
                actions = {
                    IconButton(onClick = { /* TODO */ }) {
                        Icon(imageVector = Icons.Rounded.Search, contentDescription = "Buscar")
                    }
                    IconButton(onClick = { navController.navigate("profile") }) {
                        Icon(imageVector = Icons.Outlined.AccountCircle, contentDescription = "Perfil")
                    }
                }
            )
        },

        // Barra inferior
        bottomBar = {
            BottomAppBar {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    IconButton(onClick = {
                        currentScreen = "home"; navController.navigate("home")
                    }) {
                        Icon(Icons.Filled.Home, contentDescription = "Inicio")
                    }
                    IconButton(onClick = {
                        currentScreen = "explore"; navController.navigate("explore")
                    }) {
                        Icon(Icons.Filled.Search, contentDescription = "Explorar")
                    }
                    IconButton(onClick = {
                        currentScreen = "notifications"; navController.navigate("notifications")
                    }) {
                        Icon(Icons.Filled.Notifications, contentDescription = "Notificaciones")
                    }
                    IconButton(onClick = {
                        currentScreen = "settings"; navController.navigate("settings")
                    }) {
                        Icon(Icons.Filled.Settings, contentDescription = "Configuración")
                    }
                  }
                }

},

        // Botón flotante personalizado
        floatingActionButton = {
            FloatingActionButton(onClick = { buttonPressCount++ }) {
                Icon(Icons.Filled.Add, contentDescription = "Agregar")
            }
        }
    ){ innerPadding ->
            NavHost(navController, startDestination = "home", modifier = Modifier.padding(innerPadding)) {
                composable("home") { HomeScreen(buttonPressCount) }
                composable("explore") { ExploreScreen() }
                composable("notifications") { NotificationsScreen() }
                composable("settings") { SettingsScreen() }
                composable("profile") { ProfileScreen() }
            }
        }
}

@Composable
fun HomeScreen(buttonPressCount: Int) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Pantalla de Inicio", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            "Has presionado el botón $buttonPressCount veces",
            style = MaterialTheme.typography.bodyLarge
        )
    }
}

@Composable
fun ExploreScreen() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text("Pantalla de Exploración")
    }
}

@Composable
fun NotificationsScreen() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text("Pantalla de Notificaciones")
    }
}

@Composable
fun SettingsScreen() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text("Pantalla de Configuración")
    }
}

@Composable
fun ProfileScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            imageVector = Icons.Filled.Person,
            contentDescription = "Foto de perfil",
            modifier = Modifier.size(100.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text("Nombre de Usuario", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(8.dp))
        Text("usuario@ejemplo.com", style = MaterialTheme.typography.bodyMedium)
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Labortorio06Theme {
        CustomScaffold()
    }
}