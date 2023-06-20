package com.prac.monolithic.awsmsamonolithicprac.repository

import com.prac.monolithic.awsmsamonolithicprac.entity.Product
import org.springframework.data.jpa.repository.JpaRepository

interface ProductRepository : JpaRepository<Product, Long>