package com.udacity.shoestore.store

import android.widget.EditText
import androidx.databinding.InverseBindingAdapter

class BindingAdapters {


    @InverseBindingAdapter(attribute = "android:text")
    fun EditText.getDoubleFromBinding(): Double? {
        val result=text.toString()

        return result.toDouble()
    }
}