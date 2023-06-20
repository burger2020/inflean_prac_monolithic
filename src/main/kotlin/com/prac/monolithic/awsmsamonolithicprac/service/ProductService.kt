package com.prac.monolithic.awsmsamonolithicprac.service

import com.prac.monolithic.awsmsamonolithicprac.entity.Product
import com.prac.monolithic.awsmsamonolithicprac.repository.ProductRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class ProductService(private val productRepository: ProductRepository) {

    @Transactional
    fun addProduct(product: Product): Product {
        return productRepository.save(product)
    }

    @Transactional(readOnly = true)
    fun findAllProducts(): List<Product> {
        return productRepository.findAll()
    }
}
