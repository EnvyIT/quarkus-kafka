package com.envyit.common

import io.quarkus.test.common.QuarkusTestResource
import io.quarkus.test.junit.QuarkusTest
import javax.enterprise.inject.Stereotype

@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@Stereotype
@QuarkusTest
@QuarkusTestResource(KafkaResource::class)
annotation class KafkaTest
