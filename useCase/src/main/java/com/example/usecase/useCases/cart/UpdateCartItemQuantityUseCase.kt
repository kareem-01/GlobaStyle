package com.example.usecase.useCases.cart

import com.example.usecase.repositoryInterfaces.CartRepository
import javax.inject.Inject

class UpdateCartItemQuantityUseCase @Inject constructor(
    private val repository: CartRepository
) {
    suspend operator fun invoke(itemId: String, count: String) =
        repository.updateCartProductQuantity(itemId, count)
}