package com.nhn.commerce.model

import java.time.LocalDateTime
import java.time.OffsetDateTime


data class Product(
    val productNo: Int,
    val productName: String,
    val registerYmdt: LocalDateTime?,
    val salePrice: Int,
    var updateYmdt: LocalDateTime?,
)
