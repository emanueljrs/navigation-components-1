package com.emanuel.navigationcomponents.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.emanuel.navigationcomponents.R
import com.emanuel.navigationcomponents.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonNotification.setOnClickListener {
            findNavController().navigate(R.id.from_homeFragment_to_notificationFragment)
        }

        binding.buttonProfile.setOnClickListener {
            findNavController().navigate(R.id.from_homeFragment_to_profileFragment)
        }
    }
}