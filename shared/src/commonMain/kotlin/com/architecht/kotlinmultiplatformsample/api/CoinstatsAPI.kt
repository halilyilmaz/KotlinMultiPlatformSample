package com.architecht.kotlinmultiplatformsample.api

import com.architecht.kotlinmultiplatformsample.ApplicationDispatcher
import io.ktor.client.*
import io.ktor.client.engine.*
import io.ktor.client.request.*
import io.ktor.util.Identity.decode
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import model.Coins

// https://documenter.getpostman.com/view/5734027/RzZ6Hzr3?version=latest
// https://api.coinstats.app/public/v1/coins?skip=0&limit=10
class CoinstatsAPI {
     val client: HttpClient = HttpClient()

     fun fetchCoins(success: (Coins) -> Unit, failure: (Throwable?) -> Unit) {
          GlobalScope.launch(ApplicationDispatcher) {
               try {
                    val json = client.get<String>("https://api.coinstats.app/public/v1/coins?skip=0&limit=10")

                    Json { ignoreUnknownKeys = true }.decodeFromString(Coins.serializer(), json)
                         .also(success)
               } catch (ex: Exception) {
                    failure(ex)
               }
          }
     }
}