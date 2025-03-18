package com.example.usecase.useCases.cart

import com.example.usecase.repositoryInterfaces.CartRepository
import javax.inject.Inject

class DeleteProductFromCartUseCase @Inject constructor(
    private val repository: CartRepository
){
    suspend operator fun invoke(itemId: String) = repository.deleteProductFromCart(itemId)
}