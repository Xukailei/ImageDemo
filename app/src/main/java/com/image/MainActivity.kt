package com.image

import androidx.appcompat.app.AppCompatActivity

import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.image.adapter.RecyclerAdapter
import com.image.bean.JokeBean
import com.image.present.MainPresent
import com.image.present.MainPresentImpl
import com.image.view.MainView
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.math.log

class MainActivity : AppCompatActivity(),MainView {
    private var recyclerAdapter:RecyclerAdapter ?= null
    override fun setAdapter(jokeBean: JokeBean) {
        recyclerAdapter = RecyclerAdapter(this,jokeBean.result.data)
        recycler.adapter = recyclerAdapter
    }
    var mainPresent: MainPresent? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainPresent = MainPresentImpl(this)
        val gridLayoutManager:GridLayoutManager = GridLayoutManager(this,6)
        if(gridLayoutManager!=null){
            gridLayoutManager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup(){
                override fun getSpanSize(position: Int): Int {
                    var spanSize = 0
                    when(position){
                        // 每行展示的数量 = spanCount（上面GridLayoutManager传入的数量）/spanSize
                        0,1 -> spanSize = 6
                        7,8 -> spanSize = 3
                        else -> spanSize = 2
                    }
                    return spanSize
                }
            }
        }
//        recycler.layoutManager  = LinearLayoutManager(this)
        recycler.layoutManager  = gridLayoutManager

        initData()
    }

    private fun initData() {
        mainPresent?.presentGetData("1","20","1418816972")
    }
}
