package com.envyit

import com.envyit.common.KafkaTest
import com.envyit.common.KafkaClient
import com.envyit.common.withSerializer
import com.envyit.demo.quote.Quote
import com.envyit.demo.quote.QuoteDeserializer
import com.envyit.demo.quote.QuoteSerializer
import org.apache.kafka.clients.producer.ProducerRecord
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.time.Duration


@KafkaTest
class QuoteConsumerTest {

    val kafka = KafkaClient().withSerializer(Quote::class.java, QuoteSerializer(), QuoteDeserializer())

    @Test
    fun `should consume a quote request`() {
        val quotePayload = Quote()

        kafka
            .produce(Quote::class.java)
            .fromRecords(ProducerRecord(QuoteTestHelper.TEST_TOPIC, quotePayload))
        val consumer =
            kafka
                .consume(Quote::class.java)
                .fromTopics(QuoteTestHelper.TEST_TOPIC, Duration.ofSeconds(1))
                .awaitCompletion()

        assertEquals(consumer.first().value().id, quotePayload.id)
        assertEquals(consumer.first().value().price, quotePayload.price)
    }

}
