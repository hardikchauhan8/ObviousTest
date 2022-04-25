package com.example.obvioustest.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.obvioustest.adapters.ImageListViewPagerAdapter
import com.example.obvioustest.databinding.FragmentDetailBinding
import com.example.obvioustest.viewmodel.ImageListViewModel


class DetailFragment : Fragment() {

    private val imageListViewModel: ImageListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentDetailBinding.inflate(inflater, container, false)

        val viewPager2Adapter = ImageListViewPagerAdapter(listOf())
        binding.vpImageList.adapter = viewPager2Adapter

        imageListViewModel.getImageList().observe(viewLifecycleOwner) {
            viewPager2Adapter.loadImages(it)
        }

        binding.vpImageList.post {
            binding.vpImageList.currentItem = arguments?.getInt("position", 0) ?: 0
        }

        return binding.root
    }

}