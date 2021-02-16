package com.udacity.shoestore.store

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.models.shoeList
import timber.log.Timber

class ListViewModel : ViewModel() {

    private val _shoes = MutableLiveData<ArrayList<Shoe>>()
    val shoes: LiveData<ArrayList<Shoe>>
        get() = _shoes

    private val _activeShoe = MutableLiveData<Shoe?>()
    val activeShoe: LiveData<Shoe?>
        get() = _activeShoe


    init{
        getShoeList()
    }
    private fun getShoeList() {
        _shoes.value = shoeList
        _activeShoe.value = null
    }

    fun setShoe(shoe: Shoe?){
        _activeShoe.value = shoe
        Timber.i(_activeShoe.value.toString())
    }
}


