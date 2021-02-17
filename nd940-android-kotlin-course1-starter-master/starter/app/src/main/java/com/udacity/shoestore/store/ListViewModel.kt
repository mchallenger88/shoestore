package com.udacity.shoestore.store

import android.widget.EditText
import androidx.databinding.InverseBindingAdapter
import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.models.shoeList
import timber.log.Timber

class ListViewModel : ViewModel() {

    val shoeName = ObservableField<String>()
    val shoeCompany = ObservableField<String>()
    val shoeSize = ObservableField<String>()
    val shoeDescription = ObservableField<String>()


    private val _shoes = MutableLiveData<ArrayList<Shoe>>()
    val shoes: LiveData<ArrayList<Shoe>>
        get() = _shoes

    private val _activeShoe = MutableLiveData<Shoe?>()
    val activeShoe: LiveData<Shoe?>
        get() = _activeShoe

    private val _detailTitle = MutableLiveData<String>()
    val detailTitle: LiveData<String>
        get() = _detailTitle

    private val _eventSaveShoe = MutableLiveData<Boolean>()
    val eventSaveShoe: LiveData<Boolean>
        get() = _eventSaveShoe

    private val _eventCancelShoe = MutableLiveData<Boolean>()
    val eventCancelShoe: LiveData<Boolean>
        get() = _eventCancelShoe

    init{
        getShoeList()
    }
    private fun getShoeList() {
        _shoes.value = shoeList
        _activeShoe.value = null
        _detailTitle.value = "Add New Shoe"
    }

    fun setShoe(shoe: Shoe?){
        _activeShoe.value = shoe
        if (_activeShoe.value?.name != ""){
            _detailTitle.value = "Edit Shoe"
        }else{
            _detailTitle.value = "Add New Shoe"
        }

    }

    fun saveShoe(){
        val newShoe = Shoe(
            name = shoeName.get().toString(),
            company = shoeCompany.get().toString(),
            size = shoeSize.get()?.toDouble(),
            description = shoeDescription.get().toString(),
            images = listOf<String>()
        )

        _shoes.value?.add(newShoe)

        _eventSaveShoe.value = true
    }

    fun cancelShoe(){
        _eventCancelShoe.value = true
    }

//    @InverseBindingAdapter(attribute = "android:text")
//    fun EditText.getLongFromBinding(): Long? {
//        val result=text.toString()
//
//        return result.toLong()
//    }
}


