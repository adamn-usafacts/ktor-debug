package org.usafacts.ktor.debug.domain.provider

import kotlinx.coroutines.delay
import org.usafacts.ktor.debug.domain.adapter.FailureAdapter

class FailureProvider(private val failureAdapter: FailureAdapter) {
    suspend fun getDomainFailure() {
        delay(1000)
        throw Exception("Failed in the domain layer")
    }

    suspend fun getPersistenceFailure() {
        failureAdapter.getFailure()
    }
}