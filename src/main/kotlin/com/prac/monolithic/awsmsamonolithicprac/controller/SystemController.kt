package com.prac.monolithic.awsmsamonolithicprac.controller

import com.prac.monolithic.awsmsamonolithicprac.service.SystemService
import com.sun.management.OperatingSystemMXBean
import org.springframework.http.ResponseEntity
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.lang.management.ManagementFactory
import java.net.InetAddress
import java.time.LocalDateTime
import kotlin.math.sqrt

@RestController
class SystemController(
    private val systemService: SystemService
) {

    @GetMapping("/health_check")
    @Transactional(readOnly = true)
    fun healthCheck() = ResponseEntity.ok(
        mapOf(
            "status" to "OK",
            "message" to "System is healthy",
            "ipAddress" to InetAddress.getLocalHost().hostAddress,
            "timestamp" to LocalDateTime.now(),
            "cpuUsage" to getCurrentCpuUsage(),
            "branch" to "5_1_monolithic_s3"
        )
    )


    fun getCurrentCpuUsage(): Double {
        val osBean = ManagementFactory.getOperatingSystemMXBean() as OperatingSystemMXBean
        return osBean.cpuLoad * 100
    }
}