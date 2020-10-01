package com.sheeran.demo.ui.countryInfo.presenter

import com.sheeran.demo.ui.base.presenter.BasePresenterImplementation
import com.sheeran.demo.ui.countryInfo.interactor.CountryInfoInteractor
import com.sheeran.demo.ui.countryInfo.view.CountryInfoView
import com.sheeran.demo.ui.util.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class CountryInfoPresenterImpl<V : CountryInfoView, I : CountryInfoInteractor> @Inject constructor(
    interactor: I, schedulerProvider: SchedulerProvider, compositeDisposable: CompositeDisposable
) : BasePresenterImplementation<V, I>(
    interactor = interactor,
    schedulerProvider = schedulerProvider,
    compositeDisposable = compositeDisposable
), CountryInfoPresenter<V, I> {

    override fun loadAboutCountryJSON() {
        getView()?.showProgress()
        interactor.let {
            it?.getAboutCountryList()
                ?.compose(schedulerProvider.ioToMainObservableScheduler())
                ?.subscribe { aboutResponse ->
                    getView()?.let {
                        it.hideProgress()
                        it.displayCountryInfoList(aboutResponse)
                    }
                }

        }
    }
}