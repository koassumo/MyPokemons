package com.example.mypokemons.mvp.presenter

import com.example.mypokemons.mvp.model.repo.IPokemon
import com.example.mypokemons.mvp.view.LoginView
import io.reactivex.rxjava3.core.Scheduler
import moxy.MvpPresenter
import ru.terrakok.cicerone.Router

class LoginPresenter(val mainThreadScheduler: Scheduler, val retrofitPokemon: IPokemon, val router: Router) : MvpPresenter<LoginView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        loadData()
    }

    private fun loadData() {
        retrofitPokemon.getPokemon()
                .observeOn(mainThreadScheduler)
                .subscribe({ pokemon ->

                    viewState.printPokemon(pokemon!!)

                }, {
                    println("Error: ${it.message}")
                })
    }

    fun backPressed(): Boolean {
        router.exit()
        return true
    }
}