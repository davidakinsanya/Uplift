package com.backend.uplift.plugins

import io.ktor.serialization.gson.*
import io.ktor.server.application.*
import io.ktor.server.plugins.contentnegotiation.*

/**
 * This method configures serialization in the server.
 */
fun Application.configureSerialization() {
    install(ContentNegotiation) {
        gson {}
    }
}
