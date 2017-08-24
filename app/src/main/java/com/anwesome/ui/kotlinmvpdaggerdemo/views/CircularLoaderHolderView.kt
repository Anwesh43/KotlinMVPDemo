package com.anwesome.ui.kotlinmvpdaggerdemo.views

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.MotionEvent
import android.view.View

/**
 * Created by anweshmishra on 24/08/17.
 */
class CircularLoaderHolderView(ctx: Context): View(ctx) {
    private var tapHandler: TapHandler?=null
    private var drawingHandler: DrawingHandler?=null
    private var animationHandler: AnimationHandler?=null
    private var stopAnimationHandler: StopAnimationHandler?=null
    private var startAnimationHandler: StartAnimationHandler?=null
    var paint = Paint(Paint.ANTI_ALIAS_FLAG)
    fun handleTap(handler:(Float,Float)->Unit) {
        tapHandler = TapHandler(handler)
    }
    fun handleDraw(handler:(Canvas, Paint)->Unit) {
        drawingHandler = DrawingHandler(handler)
    }
    fun handleAnimation(handler:()->Unit) {
        animationHandler = AnimationHandler(handler)
    }
    fun handleAnimationStart(handler:()->Boolean) {
        startAnimationHandler = StartAnimationHandler(handler)
    }
    fun handleAnimationStop(handler:()->Boolean) {
        stopAnimationHandler = StopAnimationHandler(handler)
    }
    override fun onDraw(canvas: Canvas) {
        canvas.drawColor(Color.parseColor("#212121"))
        drawingHandler?.handler?.invoke(canvas,paint)
        if(!(stopAnimationHandler?.handler?.invoke()?:false)) {
            animationHandler?.handler?.invoke()
            animateView()
        }
    }
    private fun animateView() {
        try {
            Thread.sleep(50)
            invalidate()
        }
        catch(ex:Exception) {

        }
    }
    override fun onTouchEvent(event: MotionEvent):Boolean {
        when(event.action) {
            MotionEvent.ACTION_DOWN -> {
                tapHandler?.handler?.invoke(event.x,event.y)
                if(startAnimationHandler?.handler?.invoke()?:false) {
                    postInvalidate()
                }
            }
        }
        return true
    }
    data class TapHandler(var handler:(Float,Float)->Unit)
    data class DrawingHandler(var handler:(Canvas, Paint)->Unit)
    data class AnimationHandler(var handler:()->Unit)
    data class StopAnimationHandler(var handler:()->Boolean)
    data class StartAnimationHandler(var handler:()->Boolean)
}