package com.example.mypokemons.mvp.model.repo.retrofit

import io.reactivex.rxjava3.schedulers.Schedulers
import com.example.mypokemons.mvp.model.api.IDataSource
import com.example.mypokemons.mvp.model.repo.IGithubUsersRepo

class RetrofitGithubUsersRepo(val api: IDataSource) : IGithubUsersRepo {
    override fun getUsers() = api.getUsers().subscribeOn(Schedulers.io())
}