package com.example.yumrush

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel


data class CartItem(val name: String, val price: String)

class CartViewModel : ViewModel() {
    private val _cartItems = mutableStateListOf<CartItem>()
    val cartItems: List<CartItem>
        get() = _cartItems

    fun addItemToCart(item: CartItem) {
        _cartItems.add(item)
    }

    fun removeItemFromCart(item: CartItem) {
        _cartItems.remove(item)
    }

    fun getCartItemCount(): Int {
        return _cartItems.size
    }
}
