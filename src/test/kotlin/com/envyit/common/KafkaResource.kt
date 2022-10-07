package com.envyit.common


import io.quarkus.test.common.QuarkusTestResourceLifecycleManager
import org.testcontainers.containers.KafkaContainer
import org.testcontainers.utility.DockerImageName

const val TEST_TOPIC = "embedded-test-topic"

class KafkaResource : QuarkusTestResourceLifecycleManager {

    private val kafkaContainer = KafkaContainer(DockerImageName.parse("confluentinc/cp-kafka:6.2.1"))

    override fun start() = kafkaContainer
        .start()
        .withConfiguration()


    private fun Unit.withConfiguration() = mapOf(
        "kafka.bootstrap.servers" to kafkaContainer.bootstrapServers,
        "mp.messaging.incoming.${TEST_TOPIC}.auto.offset.reset" to "earliest",
        "mp.messaging.incoming.${TEST_TOPIC}.connector" to "smallrye-kafka",
        "mp.messaging.incoming.${TEST_TOPIC}.value.deserializer" to "io.quarkus.kafka.client.serialization.JsonObjectDeserializer"

    )

    override fun stop() = kafkaContainer.stop()


}
