package com.prac.monolithic.awsmsamonolithicprac.controller

import com.prac.monolithic.awsmsamonolithicprac.entity.Product
import com.prac.monolithic.awsmsamonolithicprac.service.ProductService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/products")
class ProductController(
    private val productService: ProductService
) {

    @PostMapping
    fun addProduct(
        @RequestBody product: Product
    ): ResponseEntity<Product> {
        val createdProduct = productService.addProduct(product)

        return ResponseEntity.ok(createdProduct)
    }

    @GetMapping
    fun getAllProducts(): ResponseEntity<List<Product>> {
        val products = productService.findAllProducts()

        return ResponseEntity.ok(products)
    }
}
