package io.mmaltsev.vkeducation.domain.appdetails

data class AppDetails(
    open val id: String,
    val name: String,
    val developer: String,
    val category: Category,
    val ageRating: Int,
    val size: Float,
    val iconUrl: String,
    val screenshotUrlList: List<String>?,
    val description: String,
    val iconID: Int? = null,//,
)
