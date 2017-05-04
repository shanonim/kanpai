package com.sake.kanpai.network

import com.sake.kanpai.model.MenuListResponse
import com.sake.kanpai.model.SeatListResponse
import retrofit2.Call
import retrofit2.http.GET

interface KanpaiApi {

    @GET("/sendMenuList")
    fun getMenuList(): Call<MenuListResponse>

    @GET("/resVacant")
    fun getSeatStatus(): Call<SeatListResponse>

    companion object {
        val END_POINT = "http://54.249.14.213"
    }
}
