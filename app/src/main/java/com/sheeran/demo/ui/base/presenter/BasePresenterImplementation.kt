package com.sheeran.demo.ui.base.presenter

import com.sheeran.demo.ui.base.interactor.Interactor
import com.sheeran.demo.ui.base.view.BaseView
import com.sheeran.demo.ui.util.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable

abstract class BasePresenterImplementation<V : BaseView, I : Interactor> internal constructor(
    protected var interactor: I?,
    protected val schedulerProvider: SchedulerProvider,
    protected val compositeDisposable: CompositeDisposable
) : BasePresenter<V, I> {

    private var view: V? = null
    private val isViewAttached: Boolean get() = view != null

    override fun onAttach(view: V?) {
        this.view = view
    }

    override fun getView(): V? = view

    override fun onDetach() {
        compositeDisposable.dispose()
        view = null
        interactor = null
    }
}