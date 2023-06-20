package com.prac.monolithic.awsmsamonolithicprac.controller

import com.prac.monolithic.awsmsamonolithicprac.entity.Cart
import com.prac.monolithic.awsmsamonolithicprac.service.CartService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/carts")
class CartController(
    private val cartService: CartService
) {

    @PostMapping("/{cartId}/add")
    fun addToCart(
        @PathVariable cartId: Long,
        @RequestParam productId: Long,
        @RequestParam quantity: Int
    ): ResponseEntity<Cart> {
        val updatedCart = cartService.addToCart(cartId, productId, quantity)

        return ResponseEntity.ok(updatedCart)
    }
}
