package com.sheeran.demo.ui.countryInfo

import androidx.recyclerview.widget.LinearLayoutManager
import com.sheeran.demo.ui.base.view.CountryInfoAdapter
import com.sheeran.demo.ui.countryInfo.interactor.CountryInfoInteractor
import com.sheeran.demo.ui.countryInfo.interactor.CountryInfoIntractorImpl
import com.sheeran.demo.ui.countryInfo.presenter.CountryInfoPresenter
import com.sheeran.demo.ui.countryInfo.presenter.CountryInfoPresenterImpl
import com.sheeran.demo.ui.countryInfo.view.CountryInfoView
import com.sheeran.demo.ui.countryInfo.view.CountryInfoActivity
import dagger.Module
import dagger.Provides
import java.util.*

@Module
class CountryInfoModule {

    @Provides
    internal fun provideInteractor(interactor: CountryInfoIntractorImpl): CountryInfoInteractor =
        interactor

    @Provides
    internal fun providePresenter(presenter: CountryInfoPresenterImpl<CountryInfoView, CountryInfoInteractor>)
            : CountryInfoPresenter<CountryInfoView, CountryInfoInteractor> = presenter

    @Provides
    internal fun provideAdapter(): CountryInfoAdapter = CountryInfoAdapter(ArrayList())

    @Provides
    internal fun provideLinearLayoutManager(countryView: CountryInfoActivity): LinearLayoutManager =
        LinearLayoutManager(countryView)
}