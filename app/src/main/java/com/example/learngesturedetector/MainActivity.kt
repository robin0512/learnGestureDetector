package com.example.learngesturedetector

import android.annotation.SuppressLint
import android.graphics.drawable.GradientDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import androidx.core.content.ContextCompat
import com.example.learngesturedetector.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var gestureDetector: GestureDetector

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        gestureDetector = GestureDetector(this, GestureListener())
        binding.gestureView.setOnTouchListener(touchListener)
    }

    @SuppressLint("ClickableViewAccessibility")
    private val touchListener = View.OnTouchListener { view, event ->
        handleTouch(view, event)
        gestureDetector.onTouchEvent(event)
    }

    private fun handleTouch(view: View, event: MotionEvent) {
        val drawable =
            ContextCompat.getDrawable(this, R.drawable.rounded_background) as GradientDrawable

        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                drawable.setColor(ContextCompat.getColor(this, R.color.colorPressed))
            }

            MotionEvent.ACTION_UP -> {
                drawable.setColor(ContextCompat.getColor(this, R.color.colorDefault))
            }
        }
        view.background = drawable
    }

    private fun updateGestureStatusText(text: String) {
        binding.gestureText.text = text
    }

    inner class GestureListener : GestureDetector.SimpleOnGestureListener() {

        override fun onSingleTapUp(e: MotionEvent): Boolean {
            updateGestureStatusText("onSingleTapUp")
            Log.i("GestureStatus","onSingleTapUp")
            return true
        }

        override fun onLongPress(e: MotionEvent) {
            updateGestureStatusText("onLongPress")
            Log.i("GestureStatus","onLongPress")
        }

        override fun onDoubleTap(e: MotionEvent): Boolean {
            updateGestureStatusText("onDoubleTap")
            Log.i("GestureStatus","onDoubleTap")
            return true
        }

        override fun onDoubleTapEvent(e: MotionEvent): Boolean {
//            updateGestureStatusText("onDoubleTapEvent")
            Log.i("GestureStatus","onDoubleTapEvent")
            return true
        }

        override fun onDown(e: MotionEvent): Boolean {
//            updateGestureStatusText("onDown")
            Log.i("GestureStatus","onDown")
            return true
        }

        override fun onShowPress(e: MotionEvent) {
//            updateGestureStatusText("onShowPress")
            Log.i("GestureStatus","onShowPress")
        }

        override fun onSingleTapConfirmed(e: MotionEvent): Boolean {
//            updateGestureStatusText("onSingleTapConfirmed")
            Log.i("GestureStatus","onSingleTapConfirmed")
            return true
        }

        override fun onFling(
            e1: MotionEvent?,
            e2: MotionEvent,
            velocityX: Float,
            velocityY: Float
        ): Boolean {
            updateGestureStatusText("onFling")
            Log.i("GestureStatus","onFling")
            return true
        }

        override fun onScroll(
            e1: MotionEvent?,
            e2: MotionEvent,
            distanceX: Float,
            distanceY: Float
        ): Boolean {
            updateGestureStatusText("onScroll")
            Log.i("GestureStatus","onScroll")
            return true
        }
    }
}