package com.example.yumrush

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RestaurantListScreen(navController: NavController, cartViewModel: CartViewModel) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        TopAppBar(
            title = {
                Text(text = "YumRush - Explore the Restaurants")
            },
            actions = {
                CartIcon(navController, cartViewModel)
            },
            modifier = Modifier.fillMaxWidth()
        )

        // Display three restaurants with images
        RestaurantListItemWithImage(
            "President Dhaba",
            R.drawable.restaurant1,
            "Rating: 4.0",
        ) {
            // Navigate to the respective restaurant page with ID
            navController.navigate("restaurantDetails/1")
        }

        RestaurantListItemWithImage(
            "UTK",
            R.drawable.restaurant2,
            "Rating: 4.4",
        ) {
            navController.navigate("restaurantDetails/2")
        }

        RestaurantListItemWithImage(
            "C53",
            R.drawable.restaurant3,
            "Rating: 4.2",
        ) {
            navController.navigate("restaurantDetails/3")
        }
    }
}
@Composable
fun RestaurantListItemWithImage(name: String, imageResId: Int, rating: String, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { onClick() }, // Handle click event
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = imageResId),
                contentDescription = null, // You can provide a description here
                modifier = Modifier
                    .size(50.dp)
                    .clip(MaterialTheme.shapes.medium)
                    .background(MaterialTheme.colorScheme.primary)
                    .padding(4.dp),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.width(16.dp))

            Column {
                Text(text = name, style = MaterialTheme.typography.titleLarge)
                Text(text = rating, style = MaterialTheme.typography.bodySmall)
            }

            Spacer(modifier = Modifier.weight(1f))

            Icon(imageVector = Icons.Default.ArrowForward, contentDescription = null)
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CartIcon(navController: NavController, cartViewModel: CartViewModel) {
    Box(
        modifier = Modifier
            .padding(8.dp)
            .clickable {
                // Navigate to the cart screen when the icon is clicked
                navController.navigate("cart")
            }
    ) {
        Icon(
            imageVector = Icons.Default.ShoppingCart,
            contentDescription = null, // You can provide a description here
            tint = Color.White
        )

        // Display the cart item count (you can customize this part)
        val cartItemCount = cartViewModel.getCartItemCount()
        if (cartItemCount > 0) {
            Badge {
                Text(
                    text = cartItemCount.toString(),
                    color = Color.White,
                    style = TextStyle(fontSize = 12.sp),
                )
            }
        }
    }
}
