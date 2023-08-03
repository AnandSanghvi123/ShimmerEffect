package com.example.shimmereffect

import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.mylibrary.Demo
import com.facebook.shimmer.ShimmerFrameLayout

class MainActivity : AppCompatActivity() {

    private lateinit var shimmerLayout: ShimmerFrameLayout
    private lateinit var dataLayout: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        shimmerLayout = findViewById(R.id.sView)
        dataLayout = findViewById(R.id.llView)

        dataLayout.visibility = View.INVISIBLE
        shimmerLayout.startShimmer()

        loadData()

            Demo.toastMessage(this,"Hello")
    }

    private fun loadData() {

        Handler().postDelayed({
            dataLayout.visibility = View.VISIBLE
            shimmerLayout.stopShimmer()
            shimmerLayout.visibility = View.INVISIBLE
        }, 3000)

    }



    override fun onDestroy() {
        super.onDestroy()
        shimmerLayout.stopShimmer()
    }
}

