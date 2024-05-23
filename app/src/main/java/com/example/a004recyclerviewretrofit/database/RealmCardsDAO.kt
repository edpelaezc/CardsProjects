package com.example.a004recyclerviewretrofit.database

import com.example.a004recyclerviewretrofit.CardResponse
import com.example.a004recyclerviewretrofit.MoviesResponse
import io.realm.kotlin.Realm
import io.realm.kotlin.UpdatePolicy
import io.realm.kotlin.ext.query
import io.realm.kotlin.ext.toRealmList
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class RealmCardsDAO : BaseDAO() {

    companion object {
        val STORES = listOf(
            RealmCardsResponse::class
        ).toSet()
    }

    fun upsertRealmMovies(moviesResponse: CardResponse): Flow<Boolean> {
        return flow {
            val realm = Realm.open(config)
            realm.write {
                copyToRealm(RealmCardsResponse().apply {
                    userID = moviesResponse.userID
                    cardID = moviesResponse.cardID
                    cardNumber = moviesResponse.cardName
                    cardExpirationDate = moviesResponse.cardExpirationDate
                    cardCvv = moviesResponse.cardCvv
                    cardImageURL = moviesResponse.cardImageURL
                }, updatePolicy = UpdatePolicy.ALL)
            }
            realm.close()
            emit(true)
        }
    }

    fun getRealmMovies(): Flow<CardResponse?> {
        return flow {
            val realm = Realm.open(config)
            var result: CardResponse? = null
            realm.write {
                val realmCardsResponse = realm.query<RealmCardsResponse>().find()
                val realmCards = realmCardsResponse.first()!!
                result = realmCards.toCardResponse()
            }
            realm.close()
            emit(result)
        }.flowOn(Dispatchers.IO)
    }
}