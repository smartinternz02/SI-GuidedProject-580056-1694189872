package com.example.yumrush

import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun RestaurantDetailsScreen(
    navController: NavController,
    cartViewModel: CartViewModel,
    restaurantId: String?
) {
    val restaurant1Items = listOf(
        RestaurantItem("Biryani_dhaba style", "300.00", R.drawable.item_1),
        RestaurantItem("Paneer popcorn", "140.00", R.drawable.item_2),
        RestaurantItem("Chicken Popcorn", "170.00", R.drawable.item_3),
        RestaurantItem("Butter Naan with Curry", "275.00", R.drawable.item_4)
    )

    val restaurant2Items = listOf(
        RestaurantItem("UTK_Biryani", "300.00", R.drawable.item_a),
        RestaurantItem("Veg meal", "160.00", R.drawable.item_b),
        RestaurantItem("Gulab jamun", "40.00", R.drawable.item_c),
        RestaurantItem("Chicken Wings", "195.50", R.drawable.item_d)
    )

    val restaurant3Items = listOf(
        RestaurantItem("Biryani", "270.00", R.drawable.item_5),
        RestaurantItem("Apricot Delight", "150.00", R.drawable.item_6),
        RestaurantItem("Prawn tempura", "200.00", R.drawable.item_7),
        RestaurantItem("Fry piece Biryani", "350.50", R.drawable.item_8)
    )

    val restaurantItems = when (restaurantId) {
        "1" -> restaurant1Items
        "2" -> restaurant2Items
        "3" -> restaurant3Items
        else -> emptyList()
    }
    RestaurantItemsScreen(navController, restaurantId ?: "", restaurantItems, cartViewModel)
}
