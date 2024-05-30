package com.example.cryptoapp.model

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface CryptoPriceDao {
    @Query("SELECT * FROM crypto_prices")
    suspend fun getAllCryptoPrices(): List<CryptoPriceEntity>

    @Insert
    suspend fun insertCryptoPrice(cryptoPrice: CryptoPriceEntity)

    @Query("DELETE FROM crypto_prices WHERE id = :cryptoId")
    suspend fun deleteCryptoPrice(cryptoId: String)
}
