package com.example.repository.respository

import com.example.entity.cart.CartItem
import com.example.repository.dataSources.remote.RemoteDataSource
import com.example.repository.mappers.toEntity
import com.example.usecase.repositoryInterfaces.CartRepository
import javax.inject.Inject

class CartRepositoryImpl @Inject constructor(
    private val dataSource: RemoteDataSource
) : CartRepository {
    override suspend fun addToCart(productId: String) {
        dataSource.addToCart(productId)
    }

    override suspend fun getCart(): List<CartItem> {
        return dataSource.getCart().toEntity()
    }

    override suspend fun updateCartProductQuantity(itemId: String, count: String) {
        dataSource.updateCartProductQuantity(itemId, count)
    }

    override suspend fun deleteProductFromCart(itemId: String) {
        dataSource.deleteProductFromCart(itemId)
    }

    override suspend fun clearCart() {
        dataSource.clearCart()
    }
}