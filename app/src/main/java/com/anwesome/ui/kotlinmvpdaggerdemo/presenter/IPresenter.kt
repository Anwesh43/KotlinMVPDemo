package com.anwesome.ui.kotlinmvpdaggerdemo.presenter

import android.view.View
import com.anwesome.ui.kotlinmvpdaggerdemo.model.IModel

/**
 * Created by anweshmishra on 24/08/17.
 */
interface IPresenter {
    fun setView(v:View)
    fun getModel():IModel
}