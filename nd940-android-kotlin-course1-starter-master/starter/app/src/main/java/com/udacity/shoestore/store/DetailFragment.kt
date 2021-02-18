package com.udacity.shoestore.store

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.databinding.InverseBindingAdapter
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.DetailFragmentBinding
import timber.log.Timber

class DetailFragment: Fragment() {
    private lateinit var viewModel: ListViewModel
    private lateinit var binding: DetailFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {

        binding = DataBindingUtil.inflate(
                inflater,
                R.layout.detail_fragment,
                container,
                false
        )

        viewModel = ViewModelProvider(this).get(ListViewModel::class.java)
        binding.listViewModel = viewModel
        binding.lifecycleOwner = this

        viewModel.detailTitle.observe(this, Observer { x ->
            binding.invalidateAll()
            println(x)
            if (x == null){
                println("new")
                binding.editShoeTitle.text = x
            }
            if (x != null){
                println("edit")
                binding.editShoeTitle.text = x
            }
        })

        // Navigates back to shoe list when button is pressed
        viewModel.eventSaveShoe.observe(this, Observer { saved ->
            if (saved) {
                findNavController().navigate(DetailFragmentDirections.actionDetailFragmentToListFragment())

            }
        })

        // Navigates back to shoe list when button is pressed
        viewModel.eventCancelShoe.observe(this, Observer { cancel ->
            if (cancel) {
                findNavController().navigate(DetailFragmentDirections.actionDetailFragmentToListFragment())

            }
        })



        return binding.root
    }

}