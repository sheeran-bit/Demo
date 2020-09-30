package com.sheeran.demo.data.network

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class AboutResponse(
    @Expose
    @SerializedName(ApiConstants.TITLE)
    private var title: String? = null,

    @Expose
    @SerializedName(ApiConstants.ROWS)
    private var rows: List<AboutRows>? = null

)

data class AboutRows(
    @Expose
    @SerializedName(ApiConstants.TITLE)
    private var title: String? = null,
    @Expose
    @SerializedName(ApiConstants.DESCRIPTION)
    private var description: String? = null,
    @Expose
    @SerializedName(ApiConstants.IMAGE_HREF)
    private var imageHref: String? = null


)