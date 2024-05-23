package com.example.a004recyclerviewretrofit.database

import com.example.a004recyclerviewretrofit.CardResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class RealmSyncService {
    private val realmMoviesDAO: RealmCardsDAO = RealmCardsDAO()
    private val job = SupervisorJob()
    private val realmScope = CoroutineScope(Dispatchers.IO + job)
    fun doSync(moviesResponse: CardResponse) {
        realmScope.launch {

            realmMoviesDAO.upsertRealmMovies(moviesResponse)
                .catch { e ->
                    e.printStackTrace()
                }
                .collect { success ->
                    realmScope.launch {
                        realmMoviesDAO.getRealmMovies()
                            .catch { e ->
                                e.printStackTrace()
                            }
                            .collect { result ->
                                var a = result
                                var b = 3
                            }
                    }
                }
        }

    }
}