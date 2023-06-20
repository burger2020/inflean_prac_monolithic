package com.prac.monolithic.awsmsamonolithicprac.repository

import com.prac.monolithic.awsmsamonolithicprac.entity.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : JpaRepository<User, Long> {
    fun findByEmail(email: String): User?
}