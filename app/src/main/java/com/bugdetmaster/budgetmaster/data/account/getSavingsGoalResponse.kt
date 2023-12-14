package com.bugdetmaster.budgetmaster.data.account

import com.google.gson.annotations.SerializedName

data class getSavingsGoalResponse(
    @SerializedName("savings_goal")
    val savings_goal: Int
)