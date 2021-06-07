package com.shal.retrofitproject.services

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Url

interface IMessageServices {

    @GET
    fun getMessages(@Url altUrl: String): Call<String>
}