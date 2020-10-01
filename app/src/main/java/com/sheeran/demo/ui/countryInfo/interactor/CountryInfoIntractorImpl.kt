package com.sheeran.demo.ui.countryInfo.interactor

import com.sheeran.demo.data.network.AboutResponse
import com.sheeran.demo.data.network.ApiHelper
import com.sheeran.demo.ui.base.interactor.BaseInteractor
import io.reactivex.Observable
import javax.inject.Inject

class CountryInfoIntractorImpl @Inject internal constructor(apiHelper: ApiHelper) : BaseInteractor(apiHelper), CountryInfoInteractor {
    override fun getAboutCountryList()=apiHelper.loadJson()
}