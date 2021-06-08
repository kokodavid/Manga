package com.koko.manga.services

import com.koko.manga.model.FootballModel
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val  BASE_URL = "https://www.scorebat.com/video-api/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface FootballApiService {
    @GET("v1")

    suspend fun getGames(): List<FootballModel>

}

object FootballApi {
    val retrofitService: FootballApiService by lazy {
        retrofit.create(FootballApiService::class.java)
    }
}