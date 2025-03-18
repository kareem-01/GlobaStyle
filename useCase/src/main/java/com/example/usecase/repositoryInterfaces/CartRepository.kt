package com.example.usecase.repositoryInterfaces

import com.example.entity.cart.CartItem

interface CartRepository {
    suspend fun addToCart(productId: String)
    suspend fun getCart(): List<CartItem>
    suspend fun updateCartProductQuantity(itemId: String, count: String)
    suspend fun deleteProductFromCart(itemId: String)
    suspend fun clearCart()
}