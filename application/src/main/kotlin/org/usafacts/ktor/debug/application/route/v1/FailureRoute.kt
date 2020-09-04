package org.usafacts.ktor.debug.application.route.v1

import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*
import org.usafacts.ktor.debug.domain.provider.FailureProvider

fun Route.failure(failureProvider: FailureProvider) = route("v1/failure") {
    route("application") {
        get {
            throw Exception("Failed in the application layer")
        }
    }
    route("domain") {
        get {
            call.respond(failureProvider.getDomainFailure())
        }
    }
    route("persistence") {
        get {
            call.respond(failureProvider.getPersistenceFailure())
        }
    }
}
