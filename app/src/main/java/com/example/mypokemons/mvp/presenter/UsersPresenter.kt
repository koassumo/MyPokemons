package com.example.mypokemons.mvp.presenter

import com.example.igorpokemon.mvp.model.entity.PokemonSpecies
import io.reactivex.rxjava3.core.Scheduler
import moxy.MvpPresenter
import com.example.mypokemons.mvp.model.entity.GithubUser
import com.example.mypokemons.mvp.model.repo.IGithubUsersRepo
import com.example.mypokemons.mvp.presenter.list.IUserListPresenter
import com.example.mypokemons.mvp.view.UsersView
import com.example.mypokemons.mvp.view.list.UserItemView
import ru.terrakok.cicerone.Router

class UsersPresenter(val mainThreadScheduler: Scheduler, val usersRepo: IGithubUsersRepo, val router: Router) : MvpPresenter<UsersView>() {

    class UsersListPresenter : IUserListPresenter {
        val users = mutableListOf<PokemonSpecies>()

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

        usersListPresenter.itemClickListener = {itemView ->
            // TODO:
        }
    }

    private fun loadData() {
        usersRepo.getUsers()
            .observeOn(mainThreadScheduler)
            .subscribe({ users ->
                usersListPresenter.users.clear()


                val pokemonSpeciesList: MutableList<PokemonSpecies> = arrayListOf()
                users.pokemon_entries?.let {
                    for (i in 0 .. (it.size - 1) ) {
                        pokemonSpeciesList.add(it.get(i).pokemon_species!!)
                        pokemonSpeciesList[i].pokemonUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/" + (i+1) + ".png"
                    }
                }

                usersListPresenter.users.addAll(pokemonSpeciesList)
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