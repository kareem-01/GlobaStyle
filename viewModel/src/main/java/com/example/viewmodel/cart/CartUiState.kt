package com.example.viewmodel.cart

import android.graphics.Color
import com.example.entity.cart.CartItem

data class CartUiState(
    val items: List<CartProduct> = emptyList(),
    val total: Int = 0,
    val quantity: Int = 0,
    val message:String? = null,
)

data class CartProduct(
    val id: String,
    val name: String,
    val price: Int,
    val quantity: Int,
    val imageUrl: String,
    val colors: List<Color> = emptyList(),
    val sizes: List<String> = emptyList(),
)

fun CartItem.toCartProduct(): CartProduct {
    return CartProduct(
        id = id,
        name = name,
        price = price,
        quantity = quantity,
        imageUrl = imageUrl,
    )
}
fun List<CartItem>.toUiCartProduct(): List<CartProduct> =
    this.map { it.toCartProduct() }