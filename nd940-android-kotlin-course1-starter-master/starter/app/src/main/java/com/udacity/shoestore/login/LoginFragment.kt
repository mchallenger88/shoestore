package com.udacity.shoestore.login

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.LoginFragmentBinding
import timber.log.Timber

class LoginFragment  : Fragment() {
    private lateinit var viewModel: LoginViewModel

    private lateinit var binding: LoginFragmentBinding


    @SuppressLint("FragmentLiveDataObserve")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment

        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.login_fragment,
            container,
            false
        )

        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
        binding.loginViewModel = viewModel
        binding.lifecycleOwner = this

        viewModel.showError.observe(this, Observer { showError ->
            if (showError){
                binding.loginFailureText.visibility = View.VISIBLE
            }else{
                binding.loginFailureText.visibility = View.GONE

            }
        })

        viewModel.loginComplete.observe(this, Observer { loginGood ->
            if (loginGood){
                this.loginNav()
            }
        })


        return binding.root
    }

    fun loginNav(){
        val action = LoginFragmentDirections.actionLoginFragmentToOnboardingFragment()
        NavHostFragment.findNavController(this).navigate(action)
    }
}