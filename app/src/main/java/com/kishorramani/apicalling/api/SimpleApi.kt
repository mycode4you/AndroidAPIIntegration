package com.kishorramani.apicalling.api

import com.kishorramani.apicalling.pojo.signup.SignUpResponse
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.POST
import retrofit2.http.Query

interface CustomAPI {
    @POST("registration")
    suspend fun callSignUpService(
        @Query("first_name") firstName: String,
        @Query("email") email: String,
        @Query("password") title: String,
        @Query("uuid") uuid: String,
        @Query("referral") referral: String
    ): Response<SignUpResponse>
}