package com.prac.monolithic.awsmsamonolithicprac.controller

import com.sun.management.OperatingSystemMXBean
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.lang.management.ManagementFactory
import java.time.LocalDateTime

@RestController
class SystemController {

    @GetMapping("/health_check")
    fun healthCheck() = ResponseEntity.ok(
        mapOf(
            "status" to "OK",
            "message" to "System is healthy",
            "timestamp" to LocalDateTime.now(),
            "cpuUsage" to getCurrentCpuUsage(),
            "branch" to "2_monolithic_cloud",
        )
    )


    fun getCurrentCpuUsage(): Double {
        val osBean = ManagementFactory.getOperatingSystemMXBean() as OperatingSystemMXBean
        return osBean.cpuLoad * 100
    }
}