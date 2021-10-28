package model

import kotlinx.serialization.Serializable

@Serializable
data class Coin(val id: String? = null,
                val icon: String? = null,
                val name: String? = null,
                val symbol: String? = null,
                val rank: Int? = null,
                val price: Double? = null,
                val volume: Double? = null,
                val marketCap: Double? = null,
                val availableSupply: Double? = null,
                val totalSupply: Double? = null,
                val priceChange1h: Double? = null,
                val priceChange1d: Double? = null,
                val priceChange1w: Double? = null,
                val websiteUrl: String? = null,
                val redditUrl: String? = null,
                val twitterUrl: String? = null)

    /*
    "id": "bitcoin",
      "icon": "https://api.coin-stats.com/api/files/812fde17aea65fbb9f1fd8a478547bde/f3738cc5df5f59afb57111d67d951170_1.png",
      "name": "Bitcoin",
      "symbol": "BTC",
      "rank": 1,
      "price": 6362.74960614,
      "priceBtc": 1,
      "volume": 4514555849.85,
      "marketCap": 110545616313,
      "availableSupply": 17373875,
      "totalSupply": 17373875,
      "priceChange1h": 0.12,
      "priceChange1d": -0.56,
      "priceChange1w": -1.07,
      "websiteUrl": "https://bitcoin.org",
      "redditUrl": "https://www.reddit.com/r/bitcoin",
      "twitterUrl": "https://twitter.com/btc",
     */