package com.timurbahri.cryptomarket.service

import com.timurbahri.cryptomarket.model.CryptoModel
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.GET

interface CryptoAPI {

    //https://api.nomics.com/v1/
    // prices?key=8185875ee1ba7bf74917ff561539dd2a347c50c4
    //8185875ee1ba7bf74917ff561539dd2a347c50c4

    @GET("prices?key=8185875ee1ba7bf74917ff561539dd2a347c50c4")
    fun getData() : Observable<List<CryptoModel>>

    //fun getData() : Call<List<CryptoModel>>

}