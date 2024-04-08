package com.ewertonilima.kafkaproducer.service

import com.ewertonilima.kafkaproducer.dto.PaymentDto
import com.ewertonilima.kafkaproducer.producer.PaymentRequestProducer
import org.springframework.stereotype.Service

@Service
class PaymentService(
    private val paymentRequestProducer: PaymentRequestProducer
) {
    fun integratePayment(paymentDto: PaymentDto): String {
        return paymentRequestProducer.sendMessage(paymentDto)
    }
}