package com.anwesome.ui.kotlinmvpdaggerdemo.components

import android.app.Activity
import com.anwesome.ui.kotlinmvpdaggerdemo.modules.PresenterModule
import dagger.Component
import kotlin.reflect.KClass

/**
 * Created by anweshmishra on 24/08/17.
 */
@Component(modules=arrayOf(PresenterModule::class)) interface PresenterComponent{
    fun inject(activity:Activity)
}