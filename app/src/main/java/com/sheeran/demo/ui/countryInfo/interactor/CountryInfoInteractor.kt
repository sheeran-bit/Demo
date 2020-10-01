package com.sheeran.demo.ui.countryInfo.interactor

import com.sheeran.demo.data.network.AboutResponse
import com.sheeran.demo.ui.base.interactor.Interactor
import io.reactivex.Observable

interface CountryInfoInteractor : Interactor {

    fun getAboutCountryList(): Observable<AboutResponse>

}