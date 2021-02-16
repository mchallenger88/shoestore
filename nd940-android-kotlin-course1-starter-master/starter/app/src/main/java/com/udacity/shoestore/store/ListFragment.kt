package com.udacity.shoestore.store

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.ListingFragmentBinding
import com.udacity.shoestore.models.Shoe


class ListFragment  : Fragment() {
    private lateinit var viewModel: ListViewModel
    private lateinit var binding: ListingFragmentBinding

    @SuppressLint("FragmentLiveDataObserve")
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

        viewModel.shoes.observe(this, Observer { shoes ->
            shoes.forEach { shoe ->
                val txtView = TextView(activity)
                txtView.text = shoe.name
                txtView.setTextAppearance(R.style.instructcions)
                txtView.setPadding(25, 20, 25, 20)
                txtView.setOnClickListener { setShoe(shoe) }

                binding.showListLayout.addView(txtView)
            }
        })

        binding.buttonAddShoe.setOnClickListener {
            goDetail()
        }

        return binding.root
    }

    private fun setShoe(shoe: Shoe){
        viewModel.setShoe(shoe)
        view?.findNavController()?.navigate(R.id.action_listFragment_to_detailFragment)
    }

    private fun goDetail(){
        viewModel.setShoe(null)
        view?.findNavController()?.navigate(R.id.action_listFragment_to_detailFragment)
    }
}

