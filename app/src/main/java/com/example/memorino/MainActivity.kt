package com.example.memorino
import android.app.ActionBar
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val layout = LinearLayout(applicationContext)
        layout.orientation = LinearLayout.VERTICAL

        // слушатели для переворачивания с рубашки на лицевую
        val shirtListener = View.OnClickListener() {
            //
        }
        val frontListener = View.OnClickListener() {
            it.setBackgroundResource(R.drawable.rubashka)
        }

        val params = LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT)
        params.weight = 5.toFloat()

        // создание массива ImageView-s с 8 парами картинок в случайном порядке

        val frontViews = ArrayList<ImageView>()
        for(i in 1..16){
            frontViews.add(ImageView(applicationContext))
        }
        val viewsBeen = mutableListOf<Int>()
        for (i in 1..8) {
            var n = (0..15).random()
            var m = (0..15).random()
            while (n in viewsBeen){
                n = (0..15).random()
            }
            viewsBeen += n
            while (m in viewsBeen){
                m = (0..15).random()
            }
            viewsBeen += m
            Log.d("mytag", "n: $n")
            Log.d("mytag", "m: $m")
            frontViews[n] = ImageView(applicationContext).apply {
                    when(i){
                        1 -> setImageResource(R.drawable.mahjongsoul1)
                        2 -> setImageResource(R.drawable.mahjongsoul2)
                        3 -> setImageResource(R.drawable.mahjongsoul3)
                        4 -> setImageResource(R.drawable.mahjongsoul4)
                        5 -> setImageResource(R.drawable.mahjongsoul5)
                        6 -> setImageResource(R.drawable.mahjongsoul6)
                        7 -> setImageResource(R.drawable.mahjongsoul7)
                        8 -> setImageResource(R.drawable.mahjongsoul8)
                    }
                    layoutParams = params
                    setOnClickListener(frontListener)
                }
            frontViews[m] = ImageView(applicationContext).apply {
                    when(i){
                        1 -> setImageResource(R.drawable.mahjongsoul1)
                        2 -> setImageResource(R.drawable.mahjongsoul2)
                        3 -> setImageResource(R.drawable.mahjongsoul3)
                        4 -> setImageResource(R.drawable.mahjongsoul4)
                        5 -> setImageResource(R.drawable.mahjongsoul5)
                        6 -> setImageResource(R.drawable.mahjongsoul6)
                        7 -> setImageResource(R.drawable.mahjongsoul7)
                        8 -> setImageResource(R.drawable.mahjongsoul8)
                    }
                    layoutParams = params
                    setOnClickListener(frontListener)
            }
        }

        // создание массива ImageView-s с рубашками

        val shirtViews = ArrayList<ImageView>()
        for(i in 1..16) {
            shirtViews.add(ImageView(applicationContext).apply {
                setImageResource(R.drawable.rubashka)
                layoutParams = params
                setOnClickListener(shirtListener)
            })
        }

        // расположение картинок

        val rows = Array(4) { LinearLayout(applicationContext) }
        /*
        for ((count, view) in shirtViews.withIndex()) {
            val row: Int = count / 4
            rows[row].addView(view)
        }
         */
        for ((count, view) in frontViews.withIndex()) {
            val row: Int = count / 4
            rows[row].addView(view)
        }
        for (row in rows) {
            layout.addView(row)
        }
        layout.setBackgroundColor(Color.rgb(23,24,49))

        setContentView(layout)
    }
}