package com.example.mypokemons.ui.image

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.mypokemons.mvp.model.image.IImageLoader

class GlideImageLoader : IImageLoader<ImageView>  {
    override fun loadInto(url: String, container: ImageView) {
        Glide.with(container.context)
            .load(url)
            .into(container)

    }
}