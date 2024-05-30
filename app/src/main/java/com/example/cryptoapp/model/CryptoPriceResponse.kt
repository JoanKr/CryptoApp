package com.example.cryptoapp.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CryptoPriceResponse(
    val id: String,
    val symbol: String,
    val name: String,
    val current_price: Double
)

@JsonClass(generateAdapter = true)
data class CryptoPrice(
    val usd: Double?
)

