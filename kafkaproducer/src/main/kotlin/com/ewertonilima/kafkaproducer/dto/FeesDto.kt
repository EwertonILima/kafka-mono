package com.ewertonilima.kafkaproducer.dto

data class FeesDto(
    val productCode: String? = null,
    val acronymCharge: String? = null,
    val minimumValue: String? = null,
    val maximumValue: String? = null,
    var productRanges: List<RangeDto>? = null
)