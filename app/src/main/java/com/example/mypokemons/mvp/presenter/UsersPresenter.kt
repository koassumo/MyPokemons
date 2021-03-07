package com.example.mypokemons.mvp.presenter

import com.example.igorpokemon.mvp.model.entity.PokedexKanto
import com.example.igorpokemon.mvp.model.entity.UserPokemonSpecies
import io.reactivex.rxjava3.core.Scheduler
import moxy.MvpPresenter
import com.example.mypokemons.mvp.model.repo.IGithubUsersRepo
import com.example.mypokemons.mvp.presenter.list.IUserListPresenter
import com.example.mypokemons.mvp.view.UsersView
import com.example.mypokemons.mvp.view.list.UserItemView
import com.example.mypokemons.navigation.Screens
import io.reactivex.rxjava3.core.Single
import ru.terrakok.cicerone.Router

class UsersPresenter(val mainThreadScheduler: Scheduler, val usersRepo: IGithubUsersRepo, val router: Router) : MvpPresenter<UsersView>() {

    class UsersListPresenter : IUserListPresenter {
        val users = mutableListOf<UserPokemonSpecies>()

        override var itemClickListener: ((UserItemView) -> Unit)? = null

        override fun getCount() = users.size

        override fun bindView(view: UserItemView) {
            val user = users[view.pos]

            user.pokemonName?.let { view.setLogin(it) }
            user.pokemonUrl?.let {view.loadAvatar(it)}
        }
    }

    val usersListPresenter = UsersListPresenter()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()
        loadData()

        // реакция на нажатие элемента в списке здесь
        usersListPresenter.itemClickListener = {itemView ->
            val login =  usersListPresenter.users[itemView.pos].pokemonName
            router.navigateTo(Screens.LoginScreen(login!!)) //instead of "replaceScreen"
        }
    }

    private fun loadData() {
        // используется flatMap, чтобы из каждого элемента pokemon_entries в списке PokedexKanto достать pokemon_species
        usersRepo.getUsers()
            .observeOn(mainThreadScheduler)
            .subscribe({ users ->
                usersListPresenter.users.clear()
                usersListPresenter.users.addAll(users)
                viewState.updateList()
            }, {
                println("Error: ${it.message}")
            })
    }

    fun backPressed(): Boolean {
        router.exit()
        return true
    }
}