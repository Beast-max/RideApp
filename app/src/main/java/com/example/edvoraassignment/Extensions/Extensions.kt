package com.example.edvoraassignment.Extensions

import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.load(url:String?){
    if(url!=null) {
        Glide.with(this).load(url).into(this)
    }
}