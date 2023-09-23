package com.example.yumrush

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel

data class CartItem(val name: String, val price: String, val restaurantName: String, var quantity: Int)

class CartViewModel : ViewModel() {
    private val _cartItems = mutableStateListOf<CartItem>()
    val cartItems: List<CartItem>
        get() = _cartItems

    fun addItemToCart(item: CartItem) {
        val existingItem = _cartItems.find { it.name == item.name && it.restaurantName == item.restaurantName }
        if (existingItem != null) {
            existingItem.quantity++
        } else {
            _cartItems.add(item)
        }
    }

    fun removeItemFromCart(item: CartItem) {
        val existingItem = _cartItems.find { it.name == item.name && it.restaurantName == item.restaurantName }
        if (existingItem != null) {
            existingItem.quantity--
            if (existingItem.quantity == 0) {
                _cartItems.remove(existingItem)
            }
        }
    }

    fun getCartItemCount(): Int {
        var totalQuantity = 0

        for (item in _cartItems) {
            totalQuantity += item.quantity
        }

        return totalQuantity
    }
}