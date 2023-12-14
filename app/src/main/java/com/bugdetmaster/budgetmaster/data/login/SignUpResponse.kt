package com.bugdetmaster.budgetmaster.data.login

import com.google.gson.annotations.SerializedName

data class SignUpResponse (
    @SerializedName("msg")
    val msg: String
)