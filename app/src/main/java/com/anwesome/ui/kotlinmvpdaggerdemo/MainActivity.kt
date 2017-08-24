package com.anwesome.ui.kotlinmvpdaggerdemo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.anwesome.ui.kotlinmvpdaggerdemo.model.CircularLoaderHolder
import com.anwesome.ui.kotlinmvpdaggerdemo.presenter.CircularLoaderHolderPresenter
import com.anwesome.ui.kotlinmvpdaggerdemo.views.CircularLoaderHolderView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var view = CircularLoaderHolderView(this)
        var presenter = CircularLoaderHolderPresenter()
        var model = CircularLoaderHolder()
        presenter.setView(view)
        presenter.setModelContainer(model)
        presenter.handlePresentation()
        setContentView(view)
    }
}
