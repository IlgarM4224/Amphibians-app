package com.example.amphibiansapp.data

import com.example.amphibiansapp.network.AmphibiansApiService
import com.example.amphibiansapp.model.Amphibian

interface AmphibiansRepository {
    suspend fun getAmphibians(): List<Amphibian>
}

class NetworkAmphibiansRepository(private val retrofitService: AmphibiansApiService) : AmphibiansRepository {
    override suspend fun getAmphibians(): List<Amphibian> = retrofitService.getAmphibians()
}