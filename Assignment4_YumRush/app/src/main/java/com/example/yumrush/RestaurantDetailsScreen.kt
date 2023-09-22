package com.example.yumrush

import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun RestaurantDetailsScreen(
    navController: NavController,
    cartViewModel: CartViewModel,
    restaurantId: String?
) {
    // Define hardcoded restaurant item lists with images
    val restaurant1Items = listOf(
        RestaurantItem("Item 1", "10.00", R.drawable.item_1),
        RestaurantItem("Item 2", "12.00", R.drawable.item_2),
        RestaurantItem("Item 3", "8.50", R.drawable.item_3),
        RestaurantItem("Item 4", "9.50", R.drawable.item_4)
    )

    val restaurant2Items = listOf(
        RestaurantItem("Item A", "15.00", R.drawable.item_a),
        RestaurantItem("Item B", "14.00", R.drawable.item_b),
        RestaurantItem("Item C", "12.50", R.drawable.item_c),
        RestaurantItem("Item D", "11.50", R.drawable.item_d)
    )

    val restaurant3Items = listOf(
        RestaurantItem("Special 1", "20.00", R.drawable.item_5),
        RestaurantItem("Special 2", "18.00", R.drawable.item_6),
        RestaurantItem("Special 3", "17.50", R.drawable.item_7),
        RestaurantItem("Special 4", "19.50", R.drawable.item_8)
    )

    val restaurantItems = when (restaurantId) {
        "1" -> restaurant1Items
        "2" -> restaurant2Items
        "3" -> restaurant3Items
        else -> emptyList()
    }
    RestaurantItemsScreen(navController, restaurantId ?: "", restaurantItems)
}
