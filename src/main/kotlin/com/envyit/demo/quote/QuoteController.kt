package com.envyit.demo.quote

import org.eclipse.microprofile.reactive.messaging.Channel
import org.eclipse.microprofile.reactive.messaging.Emitter
import java.util.concurrent.CompletionStage
import javax.ws.rs.POST
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

@Path("api/v1/quotes")
class QuoteController(@Channel("quote-out") private val quoteEmitter: Emitter<Quote>) {

    @POST
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    fun publishQuoteRequest(): CompletionStage<Void> = quoteEmitter.send(Quote())
}