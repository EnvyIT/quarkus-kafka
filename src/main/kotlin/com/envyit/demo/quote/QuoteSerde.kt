package com.envyit.demo.quote

import io.quarkus.kafka.client.serialization.ObjectMapperDeserializer
import io.quarkus.kafka.client.serialization.ObjectMapperSerializer
import org.apache.kafka.common.serialization.Deserializer
import org.apache.kafka.common.serialization.Serializer

class QuoteSerializer : Serializer<Quote> {

    private val serializer = ObjectMapperSerializer<Quote>()

    override fun serialize(topic: String?, payload: Quote?): ByteArray = serializer.serialize(topic, payload)

}

class QuoteDeserializer : Deserializer<Quote> {

    private val deserializer = ObjectMapperDeserializer(Quote::class.java)

    override fun deserialize(topic: String?, payload: ByteArray?): Quote  = deserializer.deserialize(topic, payload)

}