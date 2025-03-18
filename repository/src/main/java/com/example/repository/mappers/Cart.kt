package com.example.repository.mappers

import com.example.entity.cart.CartItem
import com.example.repository.models.dto.cart.GetCartDto


fun GetCartDto.Data.Product.toCartItem() = CartItem(
    id = id ?: "no Id",
    name = product?.title ?: "no title",
    price = price ?: 0,
    imageUrl = product?.imageCover ?: "no image",
    quantity = count ?: 0
)

fun GetCartDto.toEntity() =
    this.data?.products?.mapNotNull { it?.toCartItem() } ?: emptyList()