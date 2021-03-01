package com.example.mypokemons.mvp.model.repo

import io.reactivex.rxjava3.core.Single
import com.example.mypokemons.mvp.model.entity.GithubUser

interface IGithubUsersRepo {
    fun getUsers(): Single<List<GithubUser>>
}