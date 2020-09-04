package org.usafacts.ktor.debug.application.route.v1

import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*
import org.usafacts.ktor.debug.domain.provider.SuccessProvider

fun Route.success(successProvider: SuccessProvider) = route("v1/success") {
    route("application") {
        get {
            call.respond("Success")
        }
    }
    route("domain") {
        get {
            call.respond(successProvider.getDomainSuccess())
        }
    }
    route("persistence") {
        get {
            call.respond(successProvider.getPersistenceSuccess())
        }
    }
}
