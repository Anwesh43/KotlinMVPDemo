package com.anwesome.ui.kotlinmvpdaggerdemo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.anwesome.ui.kotlinmvpdaggerdemo.components.PresenterComponent
import com.anwesome.ui.kotlinmvpdaggerdemo.model.CircularLoaderHolder
import com.anwesome.ui.kotlinmvpdaggerdemo.model.IModelContainer
import com.anwesome.ui.kotlinmvpdaggerdemo.presenter.CircularLoaderHolderPresenter
import com.anwesome.ui.kotlinmvpdaggerdemo.presenter.IPresenter
import com.anwesome.ui.kotlinmvpdaggerdemo.views.CircularLoaderHolderView
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
//    @Inject
//    var presenter:IPresenter?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var view = CircularLoaderHolderView(this)
        var model:IModelContainer = CircularLoaderHolder()
        var presenter = CircularLoaderHolderPresenter()
        presenter?.setView(view)
        presenter?.setModelContainer(model)
        presenter?.handlePresentation()
        setContentView(view)
    }
}
