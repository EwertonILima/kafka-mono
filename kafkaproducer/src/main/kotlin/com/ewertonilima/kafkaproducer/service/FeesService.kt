package com.ewertonilima.kafkaproducer.service

import com.ewertonilima.kafkaproducer.dto.FeesDto
import com.ewertonilima.kafkaproducer.producer.FeesStorageProducer
import org.springframework.stereotype.Service

@Service
class FeesService(
    private val feesStorageProducer: FeesStorageProducer
) {
    fun integrateFees(feesDto: FeesDto): String {
        return feesStorageProducer.sendMessage(feesDto)
    }
}