package com.example.tallerapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.tallerapp.application.ui.AnnotationSheetScreen
import com.example.tallerapp.application.ui.AnnotationsScreen
import com.example.tallerapp.application.ui.BottomAppBarItem
import com.example.tallerapp.application.ui.HomeScreen
import com.example.tallerapp.application.ui.WorkListScreen
import com.example.tallerapp.application.ui.models.Routes
import com.example.tallerapp.ui.theme.TallerAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TallerAppTheme {
                val navigationController = rememberNavController()
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    bottomBar = { BottomAppBarItem(navigationController) }
                ) { innerPadding ->
                    NavHost(
                        navController = navigationController,
                        startDestination = "home"
                    ) {
                        composable(Routes.HomeScreen.route) { HomeScreen() }
                        composable(Routes.WorkListScreen.route) { WorkListScreen(innerPadding) }
                        composable(Routes.AnnotationsScreen.route) { AnnotationsScreen(innerPadding, navigationController) }
                        composable(Routes.AnnotationSheetScreen.route) { AnnotationSheetScreen(innerPadding, navigationController) }
                    }
//                    AnnotationSheetScreen(innerPadding)
                }
            }
        }
    }
}

