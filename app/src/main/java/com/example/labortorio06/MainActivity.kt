package com.example.labortorio06

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
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
@Composable
fun CustomScaffold() {
    val navController = rememberNavController()
    Scaffold(
        // Barra superior
        topBar = { CustomTopBar(navController) },

        // Barra inferior
        bottomBar = { CustomBottomBar() },

        // Botón flotante personalizado
//        floatingActionButton = { CustomFAB()},

        // Contenido principal
        content = { padding ->
            NavHost(
                navController = navController,
                startDestination = "home",
                modifier = Modifier.padding(padding)
            ) {
//                composable("home") {
//                    CustomContent(padding)
//                }
//                composable("profile") {
//                    UserProfileView()
//                }
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Labortorio06Theme {
        CustomScaffold()
    }
}