package com.example.entity.cart

data class CartItem(
    val id: String,
    val name: String,
    val price: Int,
    val quantity: Int,
    val imageUrl: String,
)
