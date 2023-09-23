package com.example.yumrush

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.*
import com.example.yumrush.ui.theme.YumRushTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val restaurantItems = listOf(
            RestaurantItem("President Dhaba", "Rating: 4.5", R.drawable.restaurant1),
            RestaurantItem("UTK", "Rating: 4.2", R.drawable.restaurant2),
            RestaurantItem("C53", "Rating: 4.0", R.drawable.restaurant3)
        )

        setContent {
            YumRushTheme {
                val cartViewModel: CartViewModel = viewModel()
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = "login"
                ) {
                    composable("login") {
                        LoginScreen(navController)
                    }
                    composable("restaurantList") {
                        RestaurantListScreen(navController, cartViewModel)
                    }
                    composable("restaurantDetails/{restaurantId}") { backStackEntry ->
                        val restaurantId = backStackEntry.arguments?.getString("restaurantId")
                        RestaurantDetailsScreen(navController, cartViewModel, restaurantId)
                    }
                    composable("restaurantItems/{restaurantId}") { backStackEntry ->
                        val restaurantId = backStackEntry.arguments?.getString("restaurantId")
                        RestaurantItemsScreen(navController, restaurantId ?: "", restaurantItems, cartViewModel)
                    }
                    composable("cart") {
                        CartScreen(navController, cartViewModel)
                    }
                }
            }
        }
    }
}
