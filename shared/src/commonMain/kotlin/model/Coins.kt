package model

import kotlinx.serialization.Serializable

@Serializable
data class Coins(
    var coins: List<Coin>
)