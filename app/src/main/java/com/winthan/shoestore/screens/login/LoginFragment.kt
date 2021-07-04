package com.winthan.shoestore.screens.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.winthan.shoestore.R
import com.winthan.shoestore.databinding.FragmentLoginBinding

/**
 * A simple [Fragment] subclass.
 * Use the [LoginFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LoginFragment : Fragment(
    R.layout.fragment_login
) {

    private lateinit var binding: FragmentLoginBinding

    private val viewModel: LoginViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        return FragmentLoginBinding.inflate(inflater, container, false).also {
            binding = it
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnLogin.setOnClickListener {
            viewModel.login(binding.etEmail.toString(),
            binding.etPassword.toString())
        }

        binding.btnRegister.setOnClickListener {
            viewModel.register(binding.etEmail.toString(),
                binding.etPassword.toString())
        }

        viewModel.loginEvent.observe(viewLifecycleOwner, {
            when (it) {
                LoginEvent.Login -> {
                    navigateToShoeList()
                    viewModel.onFinishLogin()
                }
                LoginEvent.Register -> {
                    navigateToWelcome()
                    viewModel.onFinishLogin()
                }
            }
        })

    }

    private fun navigateToShoeList() {
        val action = LoginFragmentDirections.actionLoginFragmentToShoeListFragment()
        findNavController().navigate(action)
    }

    private fun navigateToWelcome() {
        val action = LoginFragmentDirections.actionLoginFragmentToWelcomeFragment()
        findNavController().navigate(action)
    }

}