package com.anwesome.ui.kotlinmvpdaggerdemo.presenter

import android.view.View
import com.anwesome.ui.kotlinmvpdaggerdemo.model.CircularLoaderHolder
import com.anwesome.ui.kotlinmvpdaggerdemo.model.IModel

/**
 * Created by anweshmishra on 24/08/17.
 */
class CircularLoaderHolderPresenter:IPresenter {
    override fun setView(v:View) {

    }
    override fun getModel():IModel {
        return CircularLoaderHolder()
    }

}