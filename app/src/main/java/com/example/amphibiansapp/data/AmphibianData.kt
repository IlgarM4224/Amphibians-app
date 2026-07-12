package com.example.amphibiansapp.data

import com.example.amphibiansapp.R
import com.example.amphibiansapp.model.Amphibian

object AmphibianData {
    fun getTest() = listOf(
        Amphibian(
            titleId = R.string.test_title,
            descriptionId = R.string.test_description,
            imgId = R.drawable.testimg,
        ),
        Amphibian(
            titleId = R.string.test_title,
            descriptionId = R.string.test_description,
            imgId = R.drawable.testimg,
        ),
        Amphibian(
            titleId = R.string.test_title,
            descriptionId = R.string.test_description,
            imgId = R.drawable.testimg,
        )
    )
}