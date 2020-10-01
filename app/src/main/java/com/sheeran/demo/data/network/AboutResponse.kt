package com.sheeran.demo.data.network

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class AboutResponse(
    @Expose
    @SerializedName(ApiConstants.TITLE)
    var title: String? = null,
    @Expose
    @SerializedName(ApiConstants.ROWS)
    var rows: List<AboutCountry>? = null

)

data class AboutCountry(
    @Expose
    @SerializedName(ApiConstants.TITLE)
    var title: String? = null,
    @Expose
    @SerializedName(ApiConstants.DESCRIPTION)
    var description: String? = null,
    @Expose
    @SerializedName(ApiConstants.IMAGE_HREF)
    var imageHref: String? = null


)