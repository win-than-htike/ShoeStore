package com.winthan.shoestore.screens.shoelist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.winthan.shoestore.R
import com.winthan.shoestore.databinding.FragmentShoeListBinding

class ShoeListFragment : Fragment(
    R.layout.fragment_shoe_list
) {

    private lateinit var binding: FragmentShoeListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        return FragmentShoeListBinding.inflate(inflater, container, false).also {
            binding = it
        }.root
    }

}