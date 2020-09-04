package org.usafacts.ktor.debug.domain.adapter

interface FailureAdapter {
    suspend fun getFailure()
}