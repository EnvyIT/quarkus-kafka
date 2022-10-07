package com.envyit.demo.quote

import org.eclipse.microprofile.reactive.messaging.Incoming
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class QuoteConsumer {

    @Incoming("quote-in")
    fun consume(quoteRequest: String) {
        println(quoteRequest)
    }

}