package com.example.a004recyclerviewretrofit.database

import com.example.a004recyclerviewretrofit.CardResponse

fun RealmCardsResponse.toCardResponse() = CardResponse(
    userID = userID,
    cardID = cardID,
    cardName = cardName,
    cardNumber = cardNumber,
    cardExpirationDate = cardExpirationDate,
    cardCvv = cardCvv,
    cardImageURL = cardImageURL
)