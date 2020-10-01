package com.sheeran.demo.ui.countryInfo.view

import android.os.Bundle
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.sheeran.demo.R
import com.sheeran.demo.data.network.AboutResponse
import com.sheeran.demo.ui.base.view.BaseActivity
import com.sheeran.demo.ui.base.view.CountryInfoAdapter
import com.sheeran.demo.ui.countryInfo.interactor.CountryInfoInteractor
import com.sheeran.demo.ui.countryInfo.presenter.CountryInfoPresenter
import kotlinx.android.synthetic.main.activity_country_info.*
import javax.inject.Inject

class CountryInfoActivity : BaseActivity(), CountryInfoView {


    @Inject
    internal lateinit var presenter: CountryInfoPresenter<CountryInfoView, CountryInfoInteractor>

    @Inject
    internal lateinit var layoutManager: LinearLayoutManager

    @Inject
    internal lateinit var countryInfoAdapter: CountryInfoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_country_info)
        presenter.onAttach(this)
    }

    override fun setUp() {
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        rvCountryInfo.layoutManager = layoutManager
        rvCountryInfo.itemAnimator = DefaultItemAnimator()
        rvCountryInfo.adapter = countryInfoAdapter
        presenter.loadAboutCountryJSON()
    }

    override fun displayCountryInfoList(countryInfo: AboutResponse?) {
        countryInfo?.rows?.let { countryInfoAdapter.addDataToList(it) }
    }
}
