package com.prac.monolithic.awsmsamonolithicprac.repository

import com.prac.monolithic.awsmsamonolithicprac.entity.Cart
import org.springframework.data.jpa.repository.JpaRepository

interface CartRepository: JpaRepository<Cart, Long>
