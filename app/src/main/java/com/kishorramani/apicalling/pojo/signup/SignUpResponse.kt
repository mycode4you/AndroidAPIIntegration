package com.kishorramani.apicalling.pojo.signup

import com.google.gson.annotations.SerializedName

data class SignUpResponse (
	@SerializedName("status") val status : Boolean,
	@SerializedName("message") val message : String,
	@SerializedName("data") val data : Data
)