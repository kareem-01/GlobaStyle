package com.example.viewmodel.cart

interface CartInteraction {
    fun onProductClicked(productId: String)
    fun onProductQuantityChanged(itemId: String, count: String)
    fun onProductDeleted(itemId: String)
    fun onClearCartClicked()
    fun onNextClicked()
}