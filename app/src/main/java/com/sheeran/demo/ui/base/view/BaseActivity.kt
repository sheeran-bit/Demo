package com.sheeran.demo.ui.base.view

import android.os.Bundle
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import dagger.android.AndroidInjection

abstract class BaseActivity : AppCompatActivity(), BaseView {

    private var progressBar: ProgressBar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        injectDependency()
        super.onCreate(savedInstanceState)
        setUp()
    }

    abstract fun setUp()

    private fun injectDependency() = AndroidInjection.inject(this)

    override fun showProgress() {
    }

    override fun hideProgress() {
    }
}