package com.emanuel.navigationcomponents

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.emanuel.navigationcomponents.databinding.ActivityNavigationDrawerBinding

class NavigationDrawerActivity : AppCompatActivity() {

    private val binding: ActivityNavigationDrawerBinding by lazy {
        ActivityNavigationDrawerBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // Pega a referência do navHost no layout xml
        val navHostFragment = supportFragmentManager
            .findFragmentById(binding.fragmentContainerView.id) as NavHostFragment

        // Pega o controller relacionado ao navHostFragment
        val navController = navHostFragment.navController

        // Seta no NavigationView o controller para que ele funcione com o Navigation Component
        binding.navView.setupWithNavController(navController = navController)

        // Seta na configuração da toolbar o gráfico de navegação que fará todo o controle
        // da toolbar com o Navigation Component e passando a o drawerLayout para trabalhar
        //junto com o navigation
        val appBarConfiguration = AppBarConfiguration(
            navGraph = navController.graph,
            drawerLayout = binding.drawerLayout
        )

        // Seta a toolbar com o navController e a configuração da toolbar com o gráfico
        binding.navigationDrawerToolbar.setupWithNavController(
            navController = navController,
            configuration = appBarConfiguration
        )
    }
}