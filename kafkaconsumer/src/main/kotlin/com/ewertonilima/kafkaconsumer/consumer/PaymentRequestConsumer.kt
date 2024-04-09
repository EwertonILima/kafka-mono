package com.ewertonilima.kafkaconsumer.consumer

import org.slf4j.LoggerFactory
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component

@Component
class PaymentRequestConsumer(
) {
    private val logger = LoggerFactory.getLogger(this.javaClass)

    @KafkaListener(
        topics = ["\${topics.payment.request.topic}"],
        groupId = "payment-request-consumer"
    )
    fun consume(message: String) {
        logger.info("Message received: [$message]")
    }
}