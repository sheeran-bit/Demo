package com.sheeran.demo.ui.countryInfo.view

import android.content.res.Configuration
import android.os.Bundle
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.sheeran.demo.R
import com.sheeran.demo.data.network.AboutResponse
import com.sheeran.demo.ui.base.view.BaseActivity
import com.sheeran.demo.ui.countryInfo.interactor.CountryInfoInteractor
import com.sheeran.demo.ui.countryInfo.presenter.CountryInfoPresenter
import kotlinx.android.synthetic.main.activity_country_info.*
import javax.inject.Inject


class CountryInfoActivity : BaseActivity(), CountryInfoView, SwipeRefreshLayout.OnRefreshListener {

    @Inject
    internal lateinit var presenter: CountryInfoPresenter<CountryInfoView, CountryInfoInteractor>

    @Inject
    internal lateinit var layoutManager: LinearLayoutManager

    @Inject
    internal lateinit var countryInfoAdapter: CountryInfoAdapter

    private var configurationChnage: Boolean = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_country_info)
        presenter.onAttach(this)
        srlAboutCountry.setOnRefreshListener(this);
        setUp()
    }

    //better use Viewmodel for big response
    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        configurationChnage = true
    }

    fun setUp() {
        if (!configurationChnage) {
            layoutManager.orientation = LinearLayoutManager.VERTICAL
            rvCountryInfo?.layoutManager = layoutManager
            rvCountryInfo?.itemAnimator = DefaultItemAnimator()
            rvCountryInfo?.adapter = countryInfoAdapter
            presenter.loadAboutCountryJSON()
        }
    }

    override fun displayCountryInfoList(countryInfo: AboutResponse?) {
        supportActionBar?.title = countryInfo?.title
        countryInfo?.aboutCountry?.let { countryInfoAdapter.addDataToList(it) }
        srlAboutCountry.isRefreshing = false;
    }

    override fun onRefresh() {
        srlAboutCountry.isRefreshing = true;
        presenter.loadAboutCountryJSON()
    }

    override fun onDestroy() {
        presenter.onDetach()
        super.onDestroy()
    }
}
