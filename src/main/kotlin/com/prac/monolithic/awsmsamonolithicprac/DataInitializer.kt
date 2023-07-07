package com.prac.monolithic.awsmsamonolithicprac

import com.prac.monolithic.awsmsamonolithicprac.entity.CartItem
import com.prac.monolithic.awsmsamonolithicprac.entity.Product
import com.prac.monolithic.awsmsamonolithicprac.entity.User
import com.prac.monolithic.awsmsamonolithicprac.repository.CartRepository
import com.prac.monolithic.awsmsamonolithicprac.repository.ProductRepository
import com.prac.monolithic.awsmsamonolithicprac.repository.UserRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
class DataInitializer(
    private val cartRepository: CartRepository,
    private val productRepository: ProductRepository,
    private val userRepository: UserRepository
) : CommandLineRunner {

    override fun run(vararg args: String) {
        val userCount = userRepository.count()
        val productCount = productRepository.count()
        val cartCount = cartRepository.count()
        if (userCount == 0L && productCount == 0L && cartCount == 0L) {
            val user1 = User(
                email = "burger@burger.com",
                name = "burger",
                password = "burgerpwd"
            )
            val user2 = User(
                email = "burger2@burger.com",
                name = "burger2",
                password = "burger2pwd"
            )
            val product1 = Product(
                name = "macbook m1 max 64g",
                description = "22개월 무이자 할부 가능",
                price = 3_800_000
            )
            val product2 = Product(
                name = "iphone14 pro max",
                description = "12개월 무이자 할부 가능",
                price = 1_800_000
            )
            val item1 = CartItem(
                product = product1,
                user = user1,
                quantity = 1
            )
            val item2 = CartItem(
                product = product2,
                user = user1,
                quantity = 1
            )
            val item3 = CartItem(
                product = product1,
                user = user2,
                quantity = 3
            )
            val item4 = CartItem(
                product = product2,
                user = user2,
                quantity = 2
            )
            userRepository.save(user1)
            userRepository.save(user2)
            productRepository.save(product1)
            productRepository.save(product2)
            cartRepository.save(item1)
            cartRepository.save(item2)
            cartRepository.save(item3)
            cartRepository.save(item4)
        }
    }
}