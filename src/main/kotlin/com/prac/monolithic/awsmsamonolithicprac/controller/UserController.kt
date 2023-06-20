package com.prac.monolithic.awsmsamonolithicprac.controller

import com.prac.monolithic.awsmsamonolithicprac.dto.Credentials
import com.prac.monolithic.awsmsamonolithicprac.entity.User
import com.prac.monolithic.awsmsamonolithicprac.service.UserService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/users")
class UserController(
    private val userService: UserService
) {

    @PostMapping("/register")
    fun registerUser(
        @RequestBody user: User
    ): ResponseEntity<User> {
        val registeredUser = userService.registerUser(user)

        return ResponseEntity.ok(registeredUser)
    }

    @PostMapping("/login")
    fun loginUser(
        @RequestBody credentials: Credentials
    ): ResponseEntity<User> {
        val user = userService.findByEmail(credentials)

        return ResponseEntity.ok(user)
    }

    @GetMapping("/{userId}")
    fun getUser(
        @PathVariable userId: Long
    ): ResponseEntity<User> {
        val user = userService.findById(userId)

        return ResponseEntity.ok(user)
    }
}