package com.anwesome.ui.kotlinmvpdaggerdemo.presenter

import android.view.View
import com.anwesome.ui.kotlinmvpdaggerdemo.model.CircularLoaderHolder
import com.anwesome.ui.kotlinmvpdaggerdemo.model.IModel
import com.anwesome.ui.kotlinmvpdaggerdemo.views.CircularLoaderHolderView

/**
 * Created by anweshmishra on 24/08/17.
 */
class CircularLoaderHolderPresenter:IPresenter {
    override fun setView(v:View) {
        var view = v as CircularLoaderHolderView
    }
    override fun getModel():IModel {
        return CircularLoaderHolder()
    }

}