package com.ewertonilima.kafkaproducer.producer

import com.ewertonilima.kafkaproducer.dto.FeesDto
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.beans.factory.annotation.Value
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service

@Service
class FeesStorageProducer(
    @Value("\${topics.fee.storage.topic}")
    private val feesStorageTopic: String,
    private val objectMapper: ObjectMapper,
    private val kafkaTemplate: KafkaTemplate<String, String>
) {

    fun sendMessage(feesDto: FeesDto): String {
        val content = objectMapper.writeValueAsString(feesDto)
        kafkaTemplate.send(feesStorageTopic, content)
        return "Payment sent to processing"
    }
}