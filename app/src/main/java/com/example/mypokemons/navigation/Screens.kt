package com.example.mypokemons.navigation

import com.example.mypokemons.ui.fragments.LoginFragment
import com.example.mypokemons.ui.fragments.UsersFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

class Screens {
    class UsersScreen() : SupportAppScreen() {
        override fun getFragment() = UsersFragment.newInstance()
    }

    class LoginScreen(val login: String) : SupportAppScreen() {
        override fun getFragment() = LoginFragment.newInstance(login)
    }
}