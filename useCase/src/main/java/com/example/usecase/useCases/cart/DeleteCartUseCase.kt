package com.example.usecase.useCases.cart

import com.example.usecase.repositoryInterfaces.CartRepository
import javax.inject.Inject

class DeleteCartUseCase @Inject constructor(
    private val repository: CartRepository
) {
    suspend fun invoke() = repository.clearCart()
}