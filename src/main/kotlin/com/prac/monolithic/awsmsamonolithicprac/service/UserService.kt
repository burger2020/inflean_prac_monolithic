package com.prac.monolithic.awsmsamonolithicprac.service

import com.prac.monolithic.awsmsamonolithicprac.dto.Credentials
import com.prac.monolithic.awsmsamonolithicprac.entity.User
import com.prac.monolithic.awsmsamonolithicprac.error.InvalidCredentialsException
import com.prac.monolithic.awsmsamonolithicprac.error.UserAlreadyExistsException
import com.prac.monolithic.awsmsamonolithicprac.error.UserNotFoundException
import com.prac.monolithic.awsmsamonolithicprac.repository.UserRepository
import kotlinx.coroutines.runBlocking
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional


@Service
class UserService(
    private val userRepository: UserRepository
) {


    @Transactional
    fun registerUser(user: User): User {
        val isExist = userRepository.findByEmail(user.email)
        if (isExist != null) throw UserAlreadyExistsException("User already exist with email: ${user.email}")

        return userRepository.save(user)
    }

    @Transactional(readOnly = true)
    fun findByEmail(credentials: Credentials): User? {
        val user = userRepository.findByEmail(credentials.email) ?: throw UserNotFoundException("User not found with email: ${credentials.email}")
        if (user.password != credentials.password) throw InvalidCredentialsException("Invalid credentials")

        return user
    }

    @Transactional(readOnly = true)
    fun findById(id: Long): User? {
        return userRepository.findById(id).orElseThrow { UserNotFoundException("User not found with id: $id") }
    }

    @Transactional(readOnly = true)
    fun testRdsProxyPerformance() {
        runBlocking {
            val ids = listOf(1, 2, 3, 4, 5L) // 5명의 유저
            repeat(500) { // 총 500번
                ids.forEach { id -> // 5번 씩
                    userRepository.findById(id) // 2500번 조회
                }
            }
        }
    }
}