package com.example.viewmodel.cart

sealed interface CartUiEffect {
    data object NavigateToPayment : CartUiEffect
}