package org.usafacts.ktor.debug.application

import io.ktor.application.*
import io.ktor.features.*
import io.ktor.jackson.*
import io.ktor.request.*
import io.ktor.routing.*
import io.ktor.server.engine.*
import io.ktor.server.jetty.*
import org.slf4j.event.Level
import org.usafacts.ktor.debug.application.route.v1.failure
import org.usafacts.ktor.debug.application.route.v1.success
import org.usafacts.ktor.debug.domain.data.Success
import org.usafacts.ktor.debug.domain.provider.FailureProvider
import org.usafacts.ktor.debug.domain.provider.SuccessProvider
import org.usafacts.ktor.debug.persistence.db.FailureDataAdapter
import org.usafacts.ktor.debug.persistence.db.SuccessDataAdapter

fun main(args: Array<String>) {
    embeddedServer(Jetty, port = 8080, module = Application::module).start(wait = true)
}

fun Application.module() {
    install(ContentNegotiation) {
        jackson {}
    }

    install(CallLogging) {
        level = Level.INFO
        filter { call -> call.request.path().startsWith("/") }
    }

    val failureAdapter = FailureDataAdapter()
    val successAdapter = SuccessDataAdapter(
        listOf(
            Success(foo = "fooOne", bar = "barOne"),
            Success(foo = "fooTwo", bar = "barTwo"),
            Success(foo = "fooThree", bar = "barThree")
        ).map { it.id to it }.toMap().toMutableMap()
    )

    val failureProvider = FailureProvider(failureAdapter)
    val successProvider = SuccessProvider(successAdapter)

    install(Routing) {
        failure(failureProvider)
        success(successProvider)
    }
}
