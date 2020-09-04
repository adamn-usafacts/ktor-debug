package org.usafacts.ktor.debug.domain.data

import java.time.LocalDateTime
import java.util.*

data class Failure(
    val id: UUID = UUID.randomUUID(),
    val foo: String,
    val bar: String,
    val createDate: LocalDateTime = LocalDateTime.now()
)