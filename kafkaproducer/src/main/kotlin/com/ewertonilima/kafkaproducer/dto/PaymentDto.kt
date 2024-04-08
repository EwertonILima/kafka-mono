package com.ewertonilima.kafkaproducer.dto

import java.math.BigDecimal

data class PaymentDto(
    val number: Int,
    val description: String,
    val value: BigDecimal
)
