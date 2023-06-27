package com.prac.monolithic.awsmsamonolithicprac.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import javax.sql.DataSource

@Service
@Transactional(readOnly = true)
class SystemService(
    private var dataSource: DataSource,
) {

    fun getDataConnectionUrl(): String {
        return dataSource.connection.metaData.url
    }

}
