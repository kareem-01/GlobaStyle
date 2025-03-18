package com.example.repository.models.dto.cart


import com.google.gson.annotations.SerializedName

data class AddProductToCartDto(
    @SerializedName("cartId")
    val cartId: String?,
    @SerializedName("data")
    val `data`: Data?,
    @SerializedName("message")
    val message: String?,
    @SerializedName("numOfCartItems")
    val numOfCartItems: Int?,
    @SerializedName("status")
    val status: String?
) {
    data class Data(
        @SerializedName("cartOwner")
        val cartOwner: String?,
        @SerializedName("createdAt")
        val createdAt: String?,
        @SerializedName("_id")
        val id: String?,
        @SerializedName("products")
        val products: List<Product?>?,
        @SerializedName("totalCartPrice")
        val totalCartPrice: Int?,
        @SerializedName("updatedAt")
        val updatedAt: String?,
        @SerializedName("__v")
        val v: Int?
    ) {
        data class Product(
            @SerializedName("count")
            val count: Int?,
            @SerializedName("_id")
            val id: String?,
            @SerializedName("price")
            val price: Int?,
            @SerializedName("product")
            val product: String?
        )
    }
}