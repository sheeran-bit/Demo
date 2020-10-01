package com.sheeran.demo.ui.countryInfo.presenter

import com.sheeran.demo.ui.base.interactor.Interactor
import com.sheeran.demo.ui.base.presenter.BasePresenter
import com.sheeran.demo.ui.base.view.BaseView

interface CountryInfoPresenter<V : BaseView, I : Interactor> : BasePresenter<V, I> {

    fun loadAboutCountryJSON(): Unit?
}