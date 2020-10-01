package com.sheeran.demo.ui.base.interactor

import com.sheeran.demo.data.network.ApiHelper

open class BaseInteractor() {

    protected lateinit var apiHelper: ApiHelper

    constructor(apiHelper: ApiHelper) : this() {
        this.apiHelper = apiHelper
    }
}