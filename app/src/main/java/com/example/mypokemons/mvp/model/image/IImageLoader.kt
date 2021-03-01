package com.example.mypokemons.mvp.model.image

interface IImageLoader<T> {
    fun loadInto(url: String, container: T)
}