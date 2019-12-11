package com.image.view

import com.image.bean.JokeBean

interface MainView{
    fun setAdapter(jokeBean: JokeBean)
}