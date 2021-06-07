package com.shal.retrofitproject.services

import com.shal.retrofitproject.models.Idea
import retrofit2.Call
import retrofit2.http.*
import java.util.*

interface IIdeaServices  {

    @GET("ideas/{id}")
    fun getIdea(@Path("id") id: Int): Call<Idea>

    /* @GET("ideas/owner/{owner}")
    fun getIdeasByOwner(@Path("owner") owner: String) : Call<List<Idea>>*/

    @GET("ideas")
    fun getIdeasByOwner(@QueryMap filter: HashMap<String, String>): Call<List<Idea>>

    @POST("ideas")
    fun postIdea(@Body idea: Idea): Call<Idea>

    @FormUrlEncoded
    @PUT("ideas/{id}")
    fun put(@Path("id") id: Int,
    @Field("name") name :String,
    @Field("description") description: String,
    @Field("status") status: String,
    @Field("owner") owner: String): Call<Idea>

}