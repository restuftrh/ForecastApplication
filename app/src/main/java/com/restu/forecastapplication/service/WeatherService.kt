package com.restu.forecastapplication.service

import com.restu.forecastapplication.model.Weather
import retrofit2.Response
import retrofit2.http.*


interface WeatherService {

    @GET(Constants.GET_USERS)
    suspend fun getWeather(@Query("q") lat: String,
                           @Query("appid") appid: String): Response<Weather>


//    @GET("/albums")
//    suspend fun getSortedAlbums(@Query("userId") userId: Int): Response<Albums>
//
//    @GET("/albums/{id}")
//    suspend fun getAlbum(@Path(value = "id") albumId: Int): Response<AlbumsItem>
//
//    @POST("/albums")
//    suspend fun uploadAlbum(@Body album: AlbumsItem): Response<AlbumsItem>


}