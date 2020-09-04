package org.usafacts.ktor.debug.persistence.db

import org.usafacts.ktor.debug.domain.adapter.FailureAdapter

class FailureDataAdapter : FailureAdapter {
    override suspend fun getFailure() = throw Exception("Failed in the persistence layer")
}