package com.example.jetpackcomposemvvm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.jetpackcomposemvvm.app.AppRoutes
import com.example.jetpackcomposemvvm.screens.CategoryScreen
import com.example.jetpackcomposemvvm.screens.DetailsScreen
import com.example.jetpackcomposemvvm.ui.theme.JetpackComposeMVVMTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeMVVMTheme(dynamicColor = false) {
                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = {
                                Text("Tweetsy")
                            },
                            colors = TopAppBarDefaults.topAppBarColors(
                                containerColor = MaterialTheme.colorScheme.primaryContainer,
                                titleContentColor = MaterialTheme.colorScheme.primary,
                            ),
                        )
                    },
                    modifier = Modifier.fillMaxSize(),
                ) {
                    Box(Modifier.padding(it)) {
                        App()
                    }
                }
            }
        }
    }
}

@Composable
fun App() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = AppRoutes.category) {
        composable(route = AppRoutes.category) {
            CategoryScreen(navController)
        }
        composable(route = "${AppRoutes.details}/{category}",
            arguments = listOf(navArgument("category") {
                type = NavType.StringType
            })
        ) {
            DetailsScreen()
        }
    }
}