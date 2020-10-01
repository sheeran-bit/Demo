package com.sheeran.demo.ui.countryInfo.view

import com.sheeran.demo.data.network.AboutResponse
import com.sheeran.demo.ui.base.view.BaseView

interface CountryInfoView : BaseView {

    fun displayCountryInfoList(countryInfo: AboutResponse?): Unit?
}