package com.example.remote.dataSource

import com.example.entity.Authentication.LogInBody
import com.example.entity.Authentication.SignUpBody
import com.example.remote.service.Authentication.AuthenticationService
import com.example.remote.service.cart.CartService
import com.example.remote.service.categories.CategoriesService
import com.example.remote.service.products.ProductsService
import com.example.repository.dataSources.remote.RemoteDataSource
import com.example.repository.models.dto.Authentication.LogInDto
import com.example.repository.models.dto.Authentication.SignUpDto
import com.example.repository.models.dto.brands.CategoriesDto
import com.example.repository.models.dto.brands.SubCategoriesDto
import com.example.repository.models.dto.cart.AddProductToCartDto
import com.example.repository.models.dto.cart.GetCartDto
import com.example.repository.models.dto.cart.RemoveSpecificItemFromCartDto
import com.example.repository.models.dto.cart.UpdateCartItemCountDto
import com.example.repository.models.dto.products.ProductDto
import com.example.repository.models.dto.products.ProductId
import com.example.repository.models.dto.products.ProductsDto
import com.example.repository.models.dto.products.WishListConfirmDto
import com.example.repository.models.dto.products.WishListDto
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(
    private val categoriesService: CategoriesService,
    private val authenticationService: AuthenticationService,
    private val productsService: ProductsService,
    private val cartService: CartService
) : RemoteDataSource, BaseRemoteDataSource() {
    override suspend fun signUp(body: SignUpBody): SignUpDto {
        return wrapApiCall { authenticationService.signUp(body) }
    }

    override suspend fun logIn(body: LogInBody): LogInDto {
        return wrapApiCall { authenticationService.logIn(body) }
    }

    override suspend fun getAllCategories(): CategoriesDto {
        return wrapApiCall { categoriesService.getAllCategories() }
    }

    override suspend fun getAllSubCategories(categoryId: Int): SubCategoriesDto {
        return wrapApiCall { categoriesService.getAllSubCategories() }
    }

    override suspend fun getProducts(category: String?): ProductsDto {
        return wrapApiCall { productsService.getAllProducts(category) }
    }

    override suspend fun getProductById(productId: String): ProductDto {
        return wrapApiCall { productsService.getProductById(productId) }
    }

    override suspend fun getWishList(): WishListDto {
        return wrapApiCall { productsService.getWishListItems() }
    }

    override suspend fun addProductToWishList(itemId: String): WishListConfirmDto {
        return wrapApiCall { productsService.addToWishList(ProductId(itemId)) }
    }

    override suspend fun deleteProductFromWishList(itemId: String) {
        TODO("Not yet implemented")
    }

    override suspend fun addToCart(itemId: String): AddProductToCartDto {
        return wrapApiCall { cartService.addToCart(itemId) }
    }

    override suspend fun getCart(): GetCartDto {
        return wrapApiCall { cartService.getCart() }
    }

    override suspend fun updateCartProductQuantity(
        itemId: String,
        quantity: String
    ): UpdateCartItemCountDto {
        return wrapApiCall { cartService.updateCartProductQuantity(itemId, quantity) }
    }

    override suspend fun deleteProductFromCart(itemId: String): RemoveSpecificItemFromCartDto {
        return wrapApiCall { cartService.deleteProductFromCart(itemId) }
    }

    override suspend fun clearCart() {
        return wrapApiCall { cartService.clearCart() }
    }

}