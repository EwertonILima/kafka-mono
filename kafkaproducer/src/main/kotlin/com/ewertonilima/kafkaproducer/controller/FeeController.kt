package com.ewertonilima.kafkaproducer.controller

import com.ewertonilima.kafkaproducer.dto.FeesDto
import com.ewertonilima.kafkaproducer.service.FeesService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("v1/fees")
class FeeController(
    private val feesService: FeesService
) {

    @PostMapping
    fun store(@RequestBody feeDto: FeesDto): String {
        return feesService.integrateFees(feeDto)
    }
}