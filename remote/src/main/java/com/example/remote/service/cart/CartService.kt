package com.example.remote.service.cart

import com.example.repository.models.dto.cart.AddProductToCartDto
import com.example.repository.models.dto.cart.GetCartDto
import com.example.repository.models.dto.cart.RemoveSpecificItemFromCartDto
import com.example.repository.models.dto.cart.UpdateCartItemCountDto
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface CartService {
    @POST("cart")
    suspend fun addToCart(@Body productId: String): Response<AddProductToCartDto>

    @GET("cart")
    suspend fun getCart(): Response<GetCartDto>

    @PUT("cart/{itemId}")
    suspend fun updateCartProductQuantity(
        @Path("itemId") itemId: String,
        @Body count: String
    ): Response<UpdateCartItemCountDto>

    @DELETE("cart/{itemId}")
    suspend fun deleteProductFromCart(@Path("itemId") itemId: String): Response<RemoveSpecificItemFromCartDto>

    @DELETE("cart")
    suspend fun clearCart(): Response<Unit>
}