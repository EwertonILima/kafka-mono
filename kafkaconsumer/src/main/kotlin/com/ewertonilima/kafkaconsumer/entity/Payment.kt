package com.ewertonilima.kafkaconsumer.entity

import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbAttribute
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbSortKey

@DynamoDbBean
data class Payment(
    @get:DynamoDbPartitionKey
    @get:DynamoDbAttribute("number_id")
    var number: String? = null,
    @get:DynamoDbAttribute("description")
    var description: String? = null,
    @get:DynamoDbSortKey
    @get:DynamoDbAttribute("value")
    var value: String? = null
)
