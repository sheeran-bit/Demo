package com.sheeran.demo.ui.base.presenter

import com.sheeran.demo.ui.base.interactor.Interactor
import com.sheeran.demo.ui.base.view.BaseView

interface BasePresenter<V : BaseView, I : Interactor> {

    fun onAttach(view: V?)

    fun onDetach()

    fun getView(): V?
}