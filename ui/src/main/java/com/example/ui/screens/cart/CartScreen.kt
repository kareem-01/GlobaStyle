package com.example.ui.screens.cart

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.viewmodel.cart.CartInteraction
import com.example.viewmodel.cart.CartUiState
import com.example.viewmodel.cart.CartViewModel

@Composable
fun CartScreen(
    viewModel: CartViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()
    CartScreenBody(
        state = state,
        interaction = viewModel,
    )
}

@Composable
fun CartScreenBody(
    state: CartUiState,
    interaction: CartInteraction,
    modifier: Modifier = Modifier
) {
//    GlobaScaffold {
//
//    }
    Column {
        Text(text = "Cart")
    }
}