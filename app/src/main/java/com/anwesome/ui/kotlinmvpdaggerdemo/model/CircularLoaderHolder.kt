package com.anwesome.ui.kotlinmvpdaggerdemo.model

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import java.util.concurrent.ConcurrentLinkedQueue

/**
 * Created by anweshmishra on 24/08/17.
 */
class CircularLoaderHolder:IModelContainer {
    data class CircularLoader(var x:Float,var y:Float,var scale:Float = 1.0f){
        fun draw(canvas:Canvas,paint:Paint) {
            var r = Math.min(canvas.width,canvas.height).toFloat()/20
            paint.color = Color.parseColor("#009688")
            canvas.save()
            canvas.translate(x,y)
            canvas.drawArc(RectF(-r,-r,r,r),0f,360f*scale,true,paint)
            canvas.restore()
        }
        fun update() {
            scale -= 0.1f
        }
        fun stopped():Boolean = scale <= 0f
    }
    companion object {
        var circularLoaders: ConcurrentLinkedQueue<CircularLoader> = ConcurrentLinkedQueue()
        fun create(x:Float,y:Float) {
            circularLoaders.add(CircularLoader(x,y))
        }
        fun draw(canvas:Canvas,paint:Paint) {
            circularLoaders.forEach {
                it.draw(canvas,paint)
            }
        }
        fun update() {
            circularLoaders.forEach {
                it.update()
                if(it.stopped()) {
                    circularLoaders.remove(it)
                }
            }
        }
        fun stopped():Boolean = circularLoaders.size == 0
        fun started():Boolean = circularLoaders.size == 1
    }
}