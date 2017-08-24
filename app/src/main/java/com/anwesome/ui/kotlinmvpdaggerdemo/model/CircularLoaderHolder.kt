package com.anwesome.ui.kotlinmvpdaggerdemo.model

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF

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
        fun stopped():Boolean = scale == 0f
    }
    companion object {
        fun create(x:Float,y:Float):CircularLoader = CircularLoader(x,y)
    }
}