package com.kishorramani.apicalling.pojo.signup

import com.google.gson.annotations.SerializedName

data class Data (
	@SerializedName("user_id") val user_id : Int,
	@SerializedName("first_name") val first_name : String,
	@SerializedName("email") val email : String,
	@SerializedName("activation_key") val activation_activation_key : String,
	@SerializedName("uuid") val uuid : String,
	@SerializedName("uuid_is_blocked") val uuid_is_blocked : Int,
	@SerializedName("status") val status : String,
	@SerializedName("date_activated") val date_activated : String,
	@SerializedName("date_created") val date_created : String,
	@SerializedName("date_updated") val date_updated : String,
	@SerializedName("dob") val dob : String,
	@SerializedName("referral") val referral : String,
	@SerializedName("image") val image : String,
	@SerializedName("3d_activation_status") val activation_status : Int,
	@SerializedName("phone_no") val phone_no : String,
	@SerializedName("access_token") val access_token : String,
	@SerializedName("user_records_page_count") val user_records_page_count : Int,
	@SerializedName("user_libraries_page_count") val user_libraries_page_count : Int,
	@SerializedName("is_deleted") val is_deleted : Int,
	@SerializedName("facebook_id") val facebook_id : String,
	@SerializedName("otp") val otp : String,
	@SerializedName("otp_date_created") val otp_date_created : String,
	@SerializedName("otp_date_confirmed") val otp_date_confirmed : String,
	@SerializedName("trial_days_left") val trial_days_left : Int,
	@SerializedName("records_id") val records_id : List<String>,
	@SerializedName("payment_status") val payment_status : Int
)