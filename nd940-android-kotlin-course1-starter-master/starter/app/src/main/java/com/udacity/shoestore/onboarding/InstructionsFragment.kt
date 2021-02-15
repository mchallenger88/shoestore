package com.udacity.shoestore.onboarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.InstructionsFragmentBinding
import com.udacity.shoestore.databinding.OnboardingFragmentBinding

class InstructionsFragment  : Fragment() {
    private lateinit var binding: InstructionsFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(
                inflater,
                R.layout.instructions_fragment,
                container,
                false
        )

        binding.storeListingButton.setOnClickListener{
            view?.findNavController()?.navigate(R.id.action_instructionsFragment_to_listFragment)
        }


        return binding.root
    }
}