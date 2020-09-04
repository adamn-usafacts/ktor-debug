package org.usafacts.ktor.debug.domain.provider

import kotlinx.coroutines.delay
import org.usafacts.ktor.debug.domain.adapter.SuccessAdapter

class SuccessProvider(private val successAdapter: SuccessAdapter) {
    suspend fun getDomainSuccess(): Boolean {
        delay(1000)
        return true
    }

    suspend fun getPersistenceSuccess() = successAdapter.getSuccess()
}