package com.bugdetmaster.budgetmaster.data.login

import com.google.gson.annotations.SerializedName

data class LogoutResponse(
    @SerializedName("msg")
    val msg: String
)
