package com.example.cryptoapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "crypto_prices")
data class CryptoPriceEntity(
    @PrimaryKey val id: String,
    val priceUsd: Double?
)
