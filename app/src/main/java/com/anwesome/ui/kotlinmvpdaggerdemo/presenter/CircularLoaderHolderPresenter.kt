package com.anwesome.ui.kotlinmvpdaggerdemo.presenter

import android.view.View
import com.anwesome.ui.kotlinmvpdaggerdemo.model.CircularLoaderHolder
import com.anwesome.ui.kotlinmvpdaggerdemo.model.IModelContainer
import com.anwesome.ui.kotlinmvpdaggerdemo.views.CircularLoaderHolderView
import java.util.concurrent.ConcurrentLinkedQueue

/**
 * Created by anweshmishra on 24/08/17.
 */
class CircularLoaderHolderPresenter:IPresenter {
    var view:CircularLoaderHolderView?=null
    var circularLoaderContainer:CircularLoaderHolder?=null
    override fun setView(v:View) {
        view = v as CircularLoaderHolderView
    }
    override fun setModelContainer(container: IModelContainer) {
        circularLoaderContainer = container as CircularLoaderHolder
    }
    override fun handlePresentation() {
        view?.handleTap{ x,y ->
            CircularLoaderHolder.create(x,y)
        }
        view?.handleDraw { canvas, paint ->
            CircularLoaderHolder.draw(canvas,paint)
        }
        view?.handleAnimation {
            CircularLoaderHolder.update()
        }
        view?.handleAnimationStart {
            CircularLoaderHolder.started()
        }
        view?.handleAnimationStop {
            CircularLoaderHolder.stopped()
        }
    }

}