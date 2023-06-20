package com.prac.monolithic.awsmsamonolithicprac.service

import com.prac.monolithic.awsmsamonolithicprac.entity.Cart
import com.prac.monolithic.awsmsamonolithicprac.entity.CartItem
import com.prac.monolithic.awsmsamonolithicprac.repository.CartRepository
import com.prac.monolithic.awsmsamonolithicprac.repository.ProductRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class CartService(private val cartRepository: CartRepository, private val productRepository: ProductRepository) {

    @Transactional
    fun addToCart(cartId: Long, productId: Long, quantity: Int): Cart {
        val cart = cartRepository.findById(cartId).orElseThrow { Exception("Cart not found") }
        val product = productRepository.findById(productId).orElseThrow { Exception("Product not found") }

        val cartItem = CartItem(product = product, quantity = quantity)
        cart.items.plus(cartItem)

        return cartRepository.save(cart)
    }
}
