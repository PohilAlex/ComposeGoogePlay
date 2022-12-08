package com.example.composeplay.model

import com.example.composeplay.R

data class AppInfo(
    val name: String,
    val publisherName: String,
    val rating: String,
    val reviewCount: String,
    val size: String,
    val ageRating: String,
    val screenshotRes: List<Int>,
    val aboutApp: String,
    val tags: List<String>,
    val dataSafety: String,
)

val gitHubInfo = AppInfo(
    name = "Github",
    publisherName = "Github",
    rating = "4.8",
    reviewCount = "66K reviews",
    size = "10MB",
    ageRating = "Rated for 3+",
    screenshotRes = listOf(
        R.drawable.app_screen_1,
        R.drawable.app_screen_2,
        R.drawable.app_screen_1,
        R.drawable.app_screen_2,
        R.drawable.app_screen_1,
        R.drawable.app_screen_2,
        R.drawable.app_screen_1,
        R.drawable.app_screen_2
    ),
    aboutApp = "Triage notifications, review, comment and merge, right from your mobile device",
    tags = listOf("Productivity"),
    dataSafety = "Safety starts with understanding how develops collect and share your data. " +
            "Data privacy and security practices may very based on your use, region and age." +
            " The developer provided this information and may update it over time",
)

val emptyAppInfo = AppInfo(
    name = "",
    publisherName = "",
    rating = "",
    reviewCount = "",
    size = "",
    ageRating = "",
    screenshotRes = emptyList(),
    aboutApp = "",
    tags = emptyList(),
    dataSafety = ""
)