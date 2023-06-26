package com.prac.monolithic.awsmsamonolithicprac.config

import com.zaxxer.hikari.HikariDataSource
import org.springframework.context.annotation.Configuration
import java.sql.SQLException
import javax.sql.DataSource

@Configuration
class DataSourceUtils(
    private val dataSource: DataSource
) {

    fun getDatabaseUrl(): String? {
        return if (dataSource is RoutingDataSource) {
            val currentDataSource: DataSource = dataSource.determineTargetDataSource()
            try {
                (currentDataSource as HikariDataSource).jdbcUrl
            } catch (e: SQLException) {
                "Unknown"
            }
        } else "Unknown"
    }
}