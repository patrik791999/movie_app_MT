package com.example.movie_skuska1.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

    //Data for About page
class AboutViewModel : ViewModel() {

    private val _aboutInfo = MutableLiveData<String>().apply {
        value = ("""
    |👨‍💻 Developer: Patrik Gereg
    |
    |🎓 Currently mastering the art of code at TBU in Zlin. This app, a testament to my journey, was meticulously crafted over the course of an exhilarating week.
    |
    |🎯 The raison d'être of this app? A semestral work for the subject Mobile Technologies, a stepping stone on my path of learning.
    |
    |🤖 Fun fact: This page was conjured into existence with the help of an AI from Bing.
    |
    |🙏 A Heartfelt Thank You
    |
    |To everyone who has embarked on this journey with me, your support has been my guiding light. Your encouragement, a constant source of inspiration, and your feedback, the bedrock of my growth. Thank you for investing your time in using this app. Your support is the wind beneath my wings!
""".trimMargin())


    }
    val aboutInfo : MutableLiveData<String> = _aboutInfo


}