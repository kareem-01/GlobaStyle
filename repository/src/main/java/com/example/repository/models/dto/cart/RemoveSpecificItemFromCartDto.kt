package com.example.repository.models.dto.cart


import com.google.gson.annotations.SerializedName

data class RemoveSpecificItemFromCartDto(
    @SerializedName("cartId")
    val cartId: String?,
    @SerializedName("data")
    val `data`: Data?,
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
            val product: Product?
        ) {
            data class Product(
                @SerializedName("brand")
                val brand: Brand?,
                @SerializedName("category")
                val category: Category?,
                @SerializedName("_id")
                val id: String?,
                @SerializedName("id")
                val sameid: String?,
                @SerializedName("imageCover")
                val imageCover: String?,
                @SerializedName("quantity")
                val quantity: Int?,
                @SerializedName("ratingsAverage")
                val ratingsAverage: Double?,
                @SerializedName("subcategory")
                val subcategory: List<Subcategory?>?,
                @SerializedName("title")
                val title: String?
            ) {
                data class Brand(
                    @SerializedName("_id")
                    val id: String?,
                    @SerializedName("image")
                    val image: String?,
                    @SerializedName("name")
                    val name: String?,
                    @SerializedName("slug")
                    val slug: String?
                )

                data class Category(
                    @SerializedName("_id")
                    val id: String?,
                    @SerializedName("image")
                    val image: String?,
                    @SerializedName("name")
                    val name: String?,
                    @SerializedName("slug")
                    val slug: String?
                )

                data class Subcategory(
                    @SerializedName("category")
                    val category: String?,
                    @SerializedName("_id")
                    val id: String?,
                    @SerializedName("name")
                    val name: String?,
                    @SerializedName("slug")
                    val slug: String?
                )
            }
        }
    }
}