package com.ess.kotlinretrofitsample.services

import com.ess.kotlinretrofitsample.model.PostModel
import retrofit2.Call
import retrofit2.http.GET

interface PostAPI {

    @GET("photos?albumId=1")
    fun getPosts() : Call<List<PostModel>>
}