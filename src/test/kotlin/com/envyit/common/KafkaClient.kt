package com.envyit.common

import io.smallrye.reactive.messaging.kafka.companion.KafkaCompanion
import org.apache.kafka.common.serialization.Deserializer
import org.apache.kafka.common.serialization.Serializer
import org.eclipse.microprofile.config.ConfigProvider


class KafkaClient(
    val client: KafkaCompanion = KafkaCompanion(
        ConfigProvider.getConfig().getValue("kafka.bootstrap.servers", String::class.java)
    )
)

fun <T> KafkaClient.withSerializer(clazz: Class<T>, serializer: Serializer<T>, deserializer: Deserializer<T>) =
    with(this) {
        client.registerSerde(clazz, serializer, deserializer)
        client
    }


