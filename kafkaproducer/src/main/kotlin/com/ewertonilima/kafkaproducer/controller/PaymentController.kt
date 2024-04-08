package com.ewertonilima.kafkaproducer.controller

import com.ewertonilima.kafkaproducer.dto.PaymentDto
import com.ewertonilima.kafkaproducer.service.PaymentService
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/payments")
class PaymentController(
    private val paymentService: PaymentService
) {
    @PostMapping
    fun pay(@RequestBody paymentDto: PaymentDto): String {
        return paymentService.integratePayment(paymentDto)
    }
}