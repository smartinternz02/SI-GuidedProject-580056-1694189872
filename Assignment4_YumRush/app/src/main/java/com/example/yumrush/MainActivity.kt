package com.example.yumrush

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHost
import androidx.navigation.compose.*
import com.example.yumrush.ui.theme.YumRushTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize your restaurant items as a List<RestaurantItem>
        val restaurantItems = listOf(
            RestaurantItem("Restaurant 1", "Rating: 4.5", R.drawable.restaurant1),
            RestaurantItem("Restaurant 2", "Rating: 4.2", R.drawable.restaurant2),
            RestaurantItem("Restaurant 3", "Rating: 4.0", R.drawable.restaurant3)
            // Add more restaurants as needed
        )

        setContent {
            YumRushTheme {
                // Set up navigation
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = "login"
                ) {
                    composable("login") {
                        // Replace with your login screen composable
                        LoginScreen(navController)
                    }
                    composable("restaurantList") {
                        RestaurantListScreen(navController, viewModel())
                    }
                    composable("restaurantDetails/{restaurantId}") { backStackEntry ->
                        val restaurantId = backStackEntry.arguments?.getString("restaurantId")
                        RestaurantDetailsScreen(navController, viewModel(), restaurantId)
                    }
                    composable("restaurantItems/{restaurantId}") { backStackEntry ->
                        val restaurantId = backStackEntry.arguments?.getString("restaurantId")
                        // Pass the restaurant items to the RestaurantItemsScreen here
                        RestaurantItemsScreen(navController, restaurantId ?: "", restaurantItems)
                    }
                    composable("cart") {
                        CartScreen(navController, viewModel())
                    }
                }
            }
        }
    }
}
