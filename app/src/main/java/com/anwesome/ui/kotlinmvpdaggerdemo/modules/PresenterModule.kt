package com.anwesome.ui.kotlinmvpdaggerdemo.modules

import com.anwesome.ui.kotlinmvpdaggerdemo.presenter.CircularLoaderHolderPresenter
import com.anwesome.ui.kotlinmvpdaggerdemo.presenter.IPresenter
import dagger.Module
import dagger.Provides

/**
 * Created by anweshmishra on 24/08/17.
 */
@Module class PresenterModule()  {
    @Provides fun provideCircularLoaderHolderPresenter():IPresenter = CircularLoaderHolderPresenter()
}

