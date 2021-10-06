package com.jtampinco.ticketmasterexplorer

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.jtampinco.ticketmasterexplorer.app.theme.MyDefaultTheme
import com.jtampinco.ticketmasterexplorer.ui.ViewAttractionScreen
import com.jtampinco.ticketmasterexplorer.ui.event.EventScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainContent(navController = rememberNavController())
        }
    }
}

@Composable
fun MainContent(navController: NavHostController) {
    MyDefaultTheme {
        NavHost(
            navController = navController,
            startDestination = "EventScreen"
        ) {
            composable("EventScreen") {
                EventScreen(
                    searchEventViewModel = hiltViewModel(),
                    favoriteEventViewModel = hiltViewModel(),
                    navController = navController
                )
            }
            composable("ViewAttractionScreen") {
                ViewAttractionScreen(viewModel = hiltViewModel())
            }
        }
    }
}
