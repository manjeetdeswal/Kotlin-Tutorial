package com.mddstudio.test69.Retrofit

import retrofit2.Response
import retrofit2.http.*

interface AlbService {

    @GET("/albums")
    suspend fun getalbums():Response<Albums>

    @GET("/albums")
    suspend fun getSortalbums(@Query("userId")userid:Int):Response<Albums>

    @GET("/albums/{id}")
    suspend fun getrtalb(@Path("id")albumid:Int):Response<AlbumsItem>

    @POST("/albums")
    suspend fun postrtalb(@Body albumid:AlbumsItem):Response<AlbumsItem>
}