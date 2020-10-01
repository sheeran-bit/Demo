package com.sheeran.demo.data.network

import com.rx2androidnetworking.Rx2AndroidNetworking
import io.reactivex.Observable
import javax.inject.Inject

class AppApiHelper @Inject constructor() : ApiHelper {

    override fun loadJson(): Observable<AboutResponse> =
        Rx2AndroidNetworking.get(ApiEndPoint.ENDPOINT_DEMO)
            .build()
            .getObjectObservable(AboutResponse::class.java)
}