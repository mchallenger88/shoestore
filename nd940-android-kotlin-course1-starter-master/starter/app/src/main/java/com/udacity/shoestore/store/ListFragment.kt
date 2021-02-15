package com.udacity.shoestore.store

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.ListingFragmentBinding
import timber.log.Timber

class ListFragment  : Fragment() {
    private lateinit var viewModel: ListViewModel
    private lateinit var binding: ListingFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {

        binding = DataBindingUtil.inflate(
                inflater,
                R.layout.listing_fragment,
                container,
                false
        )

        viewModel = ViewModelProvider(this).get(ListViewModel::class.java)
        binding.listViewModel = viewModel
        binding.lifecycleOwner = this

        viewModel.shoes.observe(viewLifecycleOwner, Observer { shoes ->
            shoes.forEach { shoe ->
                Timber.i(shoe.name)
            }
        })


        return inflater.inflate(R.layout.listing_fragment, container, false)
        return binding.root
    }
}

