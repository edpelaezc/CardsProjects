package com.example.a004recyclerviewretrofit.database


import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey

class RealmCardsResponse(): RealmObject {
    @PrimaryKey
    var userID: String = ""
    var cardID: String = ""
    var cardNumber: String = ""
    var cardName: String = ""
    var cardExpirationDate: String = ""
    var cardCvv: String = ""
    var cardImageURL: String = ""
}
