package org.usafacts.ktor.debug.domain.adapter

import org.usafacts.ktor.debug.domain.data.Success

interface SuccessAdapter {
    suspend fun getSuccess(): List<Success>
}