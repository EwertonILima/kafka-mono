package com.ewertonilima.kafkaconsumer.consumer

import com.ewertonilima.kafkaconsumer.entity.Payment
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import io.awspring.cloud.dynamodb.DynamoDbTemplate
import org.slf4j.LoggerFactory
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component

@Component
class PaymentRequestConsumer(
    private val dynamoDbTemplate: DynamoDbTemplate
) {
    private val logger = LoggerFactory.getLogger(this.javaClass)

    @KafkaListener(
        topics = ["\${topics.payment.request.topic}"],
        groupId = "payment-request-consumer"
    )
    fun consume(message: String) {
        logger.info("Message received: [$message]")
        val objectMapper = jacksonObjectMapper()
        val entity: Payment = objectMapper.readValue(message)
        dynamoDbTemplate.save(entity)
    }
}