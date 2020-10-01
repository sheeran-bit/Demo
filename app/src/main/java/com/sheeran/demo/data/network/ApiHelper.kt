package com.sheeran.demo.data.network

import io.reactivex.Observable

interface ApiHelper {
    fun loadJson(): Observable<AboutResponse>
}