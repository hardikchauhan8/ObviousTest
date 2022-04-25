package com.example.obvioustest.view

import android.R
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.obvioustest.adapters.ImageListAdapter
import com.example.obvioustest.databinding.FragmentImageListListBinding
import com.example.obvioustest.viewmodel.ImageListViewModel


class ImageListFragment : Fragment() {

    private val imageListViewModel: ImageListViewModel by viewModels()

    private lateinit var adapter: ImageListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.main, menu)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentImageListListBinding.inflate(inflater, container, false)

        binding.imageList.layoutManager =
            StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        adapter = ImageListAdapter(listOf())
        binding.imageList.adapter = adapter

        imageListViewModel.getImageList().observe(viewLifecycleOwner) {
            adapter.loadImages(it)
        }

        return binding.root
    }

}