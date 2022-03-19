package com.baboaisystem.feeratekit

import com.baboaisystem.feeratekit.model.FeeProviderConfig
import com.baboaisystem.feeratekit.providers.BtcCoreProvider
import com.baboaisystem.feeratekit.providers.EvmProvider
import io.reactivex.Single
import java.math.BigInteger

class FeeRateKit(providerConfig: FeeProviderConfig) {

    private val btcProvider = BtcCoreProvider(providerConfig)
    private val ethProvider = EvmProvider(providerConfig.ethEvmUrl, providerConfig.ethEvmAuth)
    private val bscProvider = EvmProvider(providerConfig.bscEvmUrl)

    fun bitcoin(blockCount: Int): Single<BigInteger> {
        return btcProvider.getFeeRate(blockCount)
    }

    fun litecoin(): Single<BigInteger> {
        return Single.just(BigInteger("1"))
    }

    fun bitcoinCash(): Single<BigInteger> {
        return Single.just(BigInteger("3"))
    }

    fun dash(): Single<BigInteger> {
        return Single.just(BigInteger("4"))
    }

    fun ethereum(): Single<BigInteger> {
        return ethProvider.getFeeRate()
    }

    fun binanceSmartChain(): Single<BigInteger> {
       return bscProvider.getFeeRate()
    }
}
