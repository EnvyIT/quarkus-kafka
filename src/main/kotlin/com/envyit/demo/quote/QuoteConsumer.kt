package com.envyit.demo.quote

import org.eclipse.microprofile.reactive.messaging.Incoming
import org.slf4j.Logger
import org.slf4j.LoggerFactory

import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class QuoteConsumer {

    companion object {
        @JvmStatic
        val logger: Logger = LoggerFactory.getLogger(QuoteConsumer::class.simpleName)
    }

    @Incoming("quote-in")
    fun consume(quoteRequest: String) {
        logger.info("Received message for UUID: $quoteRequest")
    }

}