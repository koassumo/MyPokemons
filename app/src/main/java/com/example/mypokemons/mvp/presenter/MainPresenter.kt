package com.example.mypokemons.mvp.presenter

import moxy.MvpPresenter
import com.example.mypokemons.mvp.view.MainView
import com.example.mypokemons.navigation.Screens
import ru.terrakok.cicerone.Router

class MainPresenter(val router: Router) : MvpPresenter<MainView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        router.replaceScreen(Screens.UsersScreen())
    }

    fun backClicked() {
        router.exit()
    }

}