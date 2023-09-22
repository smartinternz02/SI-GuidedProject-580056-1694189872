package com.example.yumrush

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.yumrush.CartViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RestaurantItemsScreen(navController: NavController,
                          restaurantId: String,
                          restaurantItems: List<RestaurantItem>) {
    val cartViewModel: CartViewModel = viewModel()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        TopAppBar(
            title = {
                Text(text = "Restaurant Items")
            },
            navigationIcon = {
                IconButton(
                    onClick = {
                        navController.navigateUp()
                    }
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Back"
                    )
                }
            },
            modifier = Modifier.fillMaxWidth()
        )

        // Display restaurant items with images here
        restaurantItems.forEach { item ->
            RestaurantItemCardWithImage(item) {
                // Implement "Add to Cart" functionality here
                val cartItem = CartItem(item.name, item.price)
                cartViewModel.addItemToCart(cartItem)
            }
        }
    }
}
@Composable
fun RestaurantItemCardWithImage(
    item: RestaurantItem,
    onAddToCart: () -> Unit
) {
    val cartViewModel: CartViewModel = viewModel()
    Card(
        modifier = Modifier
            .padding(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = item.imageResource),
                contentDescription = null,
                modifier = Modifier
                    .size(100.dp)
                    .clip(shape = RoundedCornerShape(2.dp)),
                contentScale = ContentScale.FillHeight
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(text = item.name, style = TextStyle(fontSize = 8.sp))
                Text(text = "Price: ${item.price}", style = TextStyle(fontSize = 16.sp))
            }
            Spacer(modifier = Modifier.width(16.dp))
            Button(
                onClick = { onAddToCart() },
                modifier = Modifier
                    .padding(10.dp),
                colors = ButtonDefaults.buttonColors(Color(0xFFCB202D)) // Red button color
            ) {
                Text(text = "Add to Cart", style = TextStyle(color = Color.White))
            }
        }
    }
}
