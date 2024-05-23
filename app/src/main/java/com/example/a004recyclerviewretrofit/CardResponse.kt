package com.example.a004recyclerviewretrofit
import com.google.gson.annotations.SerializedName

class CardResponse (
    @SerializedName("user_id")
    val userID: String,

    @SerializedName("card_id")
    val cardID: String,

    @SerializedName("card_number")
    val cardNumber: String,

    @SerializedName("card_name")
    val cardName: String,

    @SerializedName("card_expiration_date")
    val cardExpirationDate: String,

    @SerializedName("card_cvv")
    val cardCvv: String,

    @SerializedName("card_image_url")
    val cardImageURL: String
    )

data class UserIdRequest(
    val userID: String
)