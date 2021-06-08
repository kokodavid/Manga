package com.koko.manga

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.koko.manga.databinding.FragmentFootballBinding
import com.koko.manga.viewModel.FootballViewModel


class FootballFragment : Fragment() {

    private val viewModel:FootballViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentFootballBinding.inflate(inflater)
        // Inflate the layout for this fragment
        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        binding.apply {
            lifecycleOwner = this@FootballFragment
        }
        return binding.root
    }

}