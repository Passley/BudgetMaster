package com.bugdetmaster.budgetmaster.data.account

import com.google.gson.annotations.SerializedName

data class updateSavingsGoal(
    @SerializedName("reset_savings_goal")
    val reset_savings_goal: Boolean,
    @SerializedName("account_id")
    val account_id: Int,
    @SerializedName("savings_goal")
    val savings_goal: Int
)
