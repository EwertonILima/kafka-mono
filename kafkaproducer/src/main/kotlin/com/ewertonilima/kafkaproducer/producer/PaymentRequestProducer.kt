package com.ewertonilima.kafkaproducer.producer

import com.ewertonilima.kafkaproducer.dto.PaymentDto
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.beans.factory.annotation.Value
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service

@Service
class PaymentRequestProducer(
    @Value("\${topics.payment.request.topic}")
    private val paymentRequestTopic: String,
    private val objectMapper: ObjectMapper,
    private val kafkaTemplate: KafkaTemplate<String, String>
) {

    fun sendMessage(paymentDto: PaymentDto): String {
        val content = objectMapper.writeValueAsString(paymentDto)
        kafkaTemplate.send(paymentRequestTopic, content)
        return "Payment sent to processing"
    }
}