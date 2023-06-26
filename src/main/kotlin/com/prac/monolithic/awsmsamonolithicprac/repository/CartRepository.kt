package com.prac.monolithic.awsmsamonolithicprac.repository

import com.prac.monolithic.awsmsamonolithicprac.entity.CartItem
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
interface CartRepository : JpaRepository<CartItem, Long> {

    fun findByUserId(userId: Long): List<CartItem>
}
