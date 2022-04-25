package com.example.obvioustest.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.obvioustest.R
import com.example.obvioustest.databinding.RowImageListItemBinding
import com.example.obvioustest.model.SpaceImagesModel

class ImageListAdapter(
    private var imageList: List<SpaceImagesModel>
) : RecyclerView.Adapter<ImageListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            RowImageListItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = imageList[position]
        Glide.with(holder.itemView)
            .load(item.url)
            .placeholder(R.mipmap.ic_launcher)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .centerCrop()
            .into(holder.imgSpace);
        holder.tvTitle.text = item.title

        holder.itemView.setOnClickListener {
            val bundle = bundleOf("position" to position)
            holder.itemView.findNavController()
                .navigate(R.id.action_imageListFragment_to_detailFragment, bundle)
        }
    }

    override fun getItemCount(): Int = imageList.size

    fun loadImages(it: List<SpaceImagesModel>) {
        imageList = it
        notifyDataSetChanged()
    }

    inner class ViewHolder(binding: RowImageListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val imgSpace: ImageView = binding.imgSpace
        val tvTitle: TextView = binding.tvTitle
    }

}