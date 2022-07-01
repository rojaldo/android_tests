package com.example.myapplication

// import picasso
import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class ApodActivity : AppCompatActivity() {
    var tvTitle: android.widget.TextView? = null
    var imageView: android.widget.ImageView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_apod)
        val quotesApi = RetrofitHelper.getInstance().create(QuotesApi::class.java)
        // launching a new coroutine
        GlobalScope.launch {
            val result = quotesApi.getQuotes()
            if (result != null){
                Log.d("APOD", result.body()?.date.toString())
                tvTitle = findViewById(R.id.tv_title)
                tvTitle?.text = result.body()?.title.toString()
//            Picasso.get().load("https://i.imgur.com/DvpvklR.png").into(imageView);
            }
            // Checking the results

        }

    }
}