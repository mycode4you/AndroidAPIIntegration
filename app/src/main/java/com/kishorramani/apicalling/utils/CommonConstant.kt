package com.kishorramani.apicalling.utils

class CommonConstant {
    companion object {
        const val referral = "Codeash"

        fun isPasswordMatch(password: String): Boolean {
            val pattern = Regex("^(?=.{8,})(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[@#\$%^&+=]).*\$")
            if (pattern.containsMatchIn(password)) {
                return true
            }
            return false
        }
    }
}