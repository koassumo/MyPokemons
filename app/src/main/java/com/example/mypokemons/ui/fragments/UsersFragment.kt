package com.example.mypokemons.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import kotlinx.android.synthetic.main.fragment_users.*
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import com.example.mypokemons.ApiHolder
import com.example.mypokemons.App
import com.example.mypokemons.R
//import com.example.mypokemons.mvp.model.entity.room.Database
import com.example.mypokemons.mvp.model.repo.retrofit.RetrofitGithubUsersRepo
import com.example.mypokemons.mvp.presenter.UsersPresenter
import com.example.mypokemons.mvp.view.UsersView
import com.example.mypokemons.ui.BackButtonListener
import com.example.mypokemons.ui.adapter.UsersRVAdapter
import com.example.mypokemons.ui.image.GlideImageLoader
import com.example.mypokemons.mvp.model.network.AndroidNetworkStatus

class UsersFragment : MvpAppCompatFragment(), UsersView, BackButtonListener {
    companion object {
        fun newInstance() = UsersFragment()
    }

    val presenter: UsersPresenter by moxyPresenter { UsersPresenter(AndroidSchedulers.mainThread(),
//        RetrofitGithubUsersRepo(ApiHolder().api, AndroidNetworkStatus(App.instance), Database.getInstance()),
        RetrofitGithubUsersRepo(ApiHolder().api, AndroidNetworkStatus(App.instance)),
        App.instance.router) }

    var adapter: UsersRVAdapter? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) =
        View.inflate(context, R.layout.fragment_users, null)

    override fun init() {
        rv_users.layoutManager = LinearLayoutManager(context)
        adapter = UsersRVAdapter(presenter.usersListPresenter, GlideImageLoader())
        rv_users.adapter = adapter

    }

    override fun updateList() {
        adapter?.notifyDataSetChanged()
    }

    override fun backPressed() = presenter.backPressed()
}