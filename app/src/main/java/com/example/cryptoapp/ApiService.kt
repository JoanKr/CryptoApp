package com.example.cryptoapp

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("simple/price")
    fun getCryptoPrices(
        @Query("ids") ids: String = "bitcoin,ethereum,ripple,litecoin,cardano,polkadot,stellar,dogecoin,usd-coin,binancecoin,bitcoin-cash,chainlink,solana,tron,vechain,filecoin,monero,tezos,dash,eos",
        @Query("vs_currencies") vsCurrencies: String = "usd"
    ): Call<Map<String, Map<String, Double>>>
}
