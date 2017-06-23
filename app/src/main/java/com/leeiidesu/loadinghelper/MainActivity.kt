package com.leeiidesu.loadinghelper

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.leeiidesu.loading.java.LoadingHelper
import com.leeiidesu.loading.java.change.Mode

class MainActivity : AppCompatActivity(), View.OnClickListener {
    var mLoadingHelper: LoadingHelper? = null

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.button ->  mLoadingHelper!!.showOrigin()
            R.id.button2 -> mLoadingHelper!!.showLoading()
            R.id.button3 -> mLoadingHelper!!.showEmpty()
            R.id.button4 -> mLoadingHelper!!.showError()
            R.id.button5 -> mLoadingHelper!!.showNoNetwork()
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        findViewById(R.id.button).setOnClickListener(this)
        findViewById(R.id.button2).setOnClickListener(this)
        findViewById(R.id.button3).setOnClickListener(this)
        findViewById(R.id.button4).setOnClickListener(this)
        findViewById(R.id.button5).setOnClickListener(this)
        val findViewById = findViewById(R.id.content)!!
        mLoadingHelper = LoadingHelper.with(findViewById, Mode.COVER)

    }
}
