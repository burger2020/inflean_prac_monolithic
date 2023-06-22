package com.prac.monolithic.awsmsamonolithicprac.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDateTime

@RestController
class SystemController {

    @GetMapping("/health_check")
    fun healthCheck() = ResponseEntity.ok(
        mapOf(
            "status" to "OK",
            "message" to "System is healthy",
            "timestamp" to LocalDateTime.now()
        )
    )
}