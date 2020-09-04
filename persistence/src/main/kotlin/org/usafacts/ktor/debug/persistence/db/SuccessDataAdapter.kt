package org.usafacts.ktor.debug.persistence.db

import org.usafacts.ktor.debug.domain.adapter.SuccessAdapter
import org.usafacts.ktor.debug.domain.data.Success
import java.util.*

class SuccessDataAdapter(
    private val map: MutableMap<UUID, Success> = mutableMapOf()
) : SuccessAdapter {
    override suspend fun getSuccess() = map.values.toList()
}