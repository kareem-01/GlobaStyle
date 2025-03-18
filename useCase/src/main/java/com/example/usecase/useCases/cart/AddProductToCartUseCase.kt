package com.example.usecase.useCases.cart

import com.example.usecase.repositoryInterfaces.CartRepository
import javax.inject.Inject

class AddProductToCartUseCase @Inject constructor(
    private val repository: CartRepository
) {
    suspend operator fun invoke(productId: String) = repository.addToCart(productId)
}