package com.example.mypokemons.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mypokemons.ApiHolder
import com.example.mypokemons.App
import com.example.mypokemons.R
import com.example.mypokemons.mvp.model.entity.Pokemon
import com.example.mypokemons.mvp.model.repo.retrofit.RetrofitPokemon
import com.example.mypokemons.mvp.presenter.LoginPresenter
import com.example.mypokemons.mvp.view.LoginView
import com.example.mypokemons.ui.image.GlideImageLoader
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import kotlinx.android.synthetic.main.fragment_login.*
import kotlinx.android.synthetic.main.item_user.view.*
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class LoginFragment : MvpAppCompatFragment(), LoginView {

    val presenter: LoginPresenter by moxyPresenter {
        LoginPresenter(AndroidSchedulers.mainThread(),
                RetrofitPokemon(ApiHolder().api, arguments!!.getString(USER_ARG, USER_ARG)),
                App.instance.router)
    }
    companion object {
        private const val USER_ARG = "user"
        fun newInstance(login: String) = LoginFragment().apply {
            arguments = Bundle().apply {
                putString(USER_ARG, login)
            }
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) =
            View.inflate(context, R.layout.fragment_login, null)

    override fun printPokemon(pokemon: Pokemon) {
        tv_pokemon_name.text = "name: " + pokemon.pokName
        tv_weight.text = "weight: " + pokemon.pokWeight
        tv_base_experience.text = "base_experience: " + pokemon.pokBaseExperience
        GlideImageLoader().loadInto(pokemon.pokemonSpritesAvatars!!.pokAvatar!!, iv_avatar)
        // Glide, по-хорошему, нужно спрятать за интерфейс. потом
    }

//    override fun backPressed(): Boolean {
//        TODO("Not yet implemented")
//    }


}