package com.example.viewmodel.cart

import com.example.entity.cart.CartItem
import com.example.usecase.useCases.cart.DeleteCartUseCase
import com.example.usecase.useCases.cart.DeleteProductFromCartUseCase
import com.example.usecase.useCases.cart.GetCartUseCase
import com.example.usecase.useCases.cart.UpdateCartItemQuantityUseCase
import com.example.viewmodel.BaseViewModel
import javax.inject.Inject

class CartViewModel @Inject constructor(
    private val getCartItemsUseCase: GetCartUseCase,
    private val updateCartItemQuantityUseCase: UpdateCartItemQuantityUseCase,
    private val removeCartItemUseCase: DeleteProductFromCartUseCase,
    private val deleteCartUseCartProduct: DeleteCartUseCase
) : BaseViewModel<CartUiState, CartUiEffect>(CartUiState()), CartInteraction {

    init {
        getCartItems()
    }

    private fun getCartItems() {
        tryToExecute(
            {
                getCartItemsUseCase()
            }, ::onGetCartItemsSuccess, ::onGetCartItemsError
        )
    }

    private fun onGetCartItemsError(exception: Exception) {
        updateState { copy(message = exception.message) }
    }

    private fun onGetCartItemsSuccess(cartItems: List<CartItem>) {
        updateState { copy(items = cartItems.toUiCartProduct()) }
    }

    override fun onProductClicked(productId: String) {

    }

    override fun onProductQuantityChanged(itemId: String, count: String) {
        TODO("Not yet implemented")
    }

    override fun onProductDeleted(itemId: String) {
        TODO("Not yet implemented")
    }

    override fun onClearCartClicked() {
        TODO("Not yet implemented")
    }

    override fun onNextClicked() {
        TODO("Not yet implemented")
    }

}