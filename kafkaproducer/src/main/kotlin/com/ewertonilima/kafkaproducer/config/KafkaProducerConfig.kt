package com.ewertonilima.kafkaproducer.config

import org.apache.kafka.clients.admin.NewTopic
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.autoconfigure.kafka.KafkaProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.config.TopicBuilder
import org.springframework.kafka.core.DefaultKafkaProducerFactory
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.kafka.core.ProducerFactory

@Configuration
class KafkaProducerConfig(
    private val kafkaProperties: KafkaProperties,
    @Value("\${topics.payment.request.topic}")
    private val paymentRequestTopic: String,
    @Value("\${topics.fee.storage.topic}")
    private val feesStorageTopic: String
) {

    @Bean
    fun producerFactory(): ProducerFactory<String, String> {
        val properties = kafkaProperties.buildProducerProperties()
        return DefaultKafkaProducerFactory(properties)
    }

    @Bean
    fun kafkaTemplate(): KafkaTemplate<String, String> {
        return KafkaTemplate(producerFactory())
    }

    @Bean
    fun paymentRequestTopicBuilder(): NewTopic {
        return TopicBuilder
            .name(paymentRequestTopic)
            .partitions(1)
            .replicas(1)
            .build()
    }

    @Bean
    fun feesStorageTopicBuilder(): NewTopic {
        return TopicBuilder
            .name(feesStorageTopic)
            .partitions(1)
            .replicas(1)
            .build()
    }
}