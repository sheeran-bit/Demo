package com.sheeran.demo.di.builder

import com.sheeran.demo.ui.countryInfo.CountryInfoModule
import com.sheeran.demo.ui.countryInfo.view.CountryInfoActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = [(CountryInfoModule::class)])
    abstract fun bindCountryInfoActivity(): CountryInfoActivity
}