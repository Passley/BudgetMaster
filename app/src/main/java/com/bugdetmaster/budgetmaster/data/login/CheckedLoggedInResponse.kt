package com.bugdetmaster.budgetmaster.data.login

import com.google.gson.annotations.SerializedName

data class checkedLoggedInResponse(
    @SerializedName("IsLoggedIn")
    val IsLoggedIn: String
)
