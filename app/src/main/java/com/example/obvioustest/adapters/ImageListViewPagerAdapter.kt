package com.example.obvioustest.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.obvioustest.R
import com.example.obvioustest.databinding.RowImageItemViewPagerBinding
import com.example.obvioustest.model.SpaceImagesModel

class ImageListViewPagerAdapter(
    private var imageList: List<SpaceImagesModel>
) : RecyclerView.Adapter<ImageListViewPagerAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            RowImageItemViewPagerBinding.inflate(
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
        holder.tvDesc.text = item.explanation
    }

    override fun getItemCount(): Int = imageList.size

    fun loadImages(it: List<SpaceImagesModel>) {
        imageList = it
        notifyDataSetChanged()
    }

    inner class ViewHolder(binding: RowImageItemViewPagerBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val imgSpace: ImageView = binding.imgSpace
        val tvTitle: TextView = binding.tvTitle
        val tvDesc: TextView = binding.tvDesc
    }

}