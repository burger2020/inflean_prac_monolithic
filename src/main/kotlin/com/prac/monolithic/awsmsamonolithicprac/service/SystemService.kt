package com.prac.monolithic.awsmsamonolithicprac.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import javax.sql.DataSource

@Service
@Transactional(readOnly = true)
class SystemService(
    private var dataSource: DataSource,
) {

    var connectionDBUrl: String? = null
    fun getDataConnectionUrl(): String {
        if (connectionDBUrl == null) connectionDBUrl = dataSource.connection.metaData.url
        return connectionDBUrl ?: "Unknown"
    }
}
