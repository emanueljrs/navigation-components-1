package com.emanuel.navigationcomponents

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.emanuel.navigationcomponents.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // Pega a referência do navHost no layout xml
        val navHostFragment = supportFragmentManager
            .findFragmentById(binding.fragmentContainerView.id) as NavHostFragment
        // Pega o controller relacionado ao navHostFragment
        val navController = navHostFragment.navController
        // Seta na configuração da toolbar o gráfico de navegação que fará todo o controle
        // da toolbar com o Navigation Component
        val appToolbarConfig = AppBarConfiguration(navGraph = navController.graph)

        // Seta a toolbar com o navController e a configuração da toolbar com o gráfico
        binding.mainToolbar.setupWithNavController(
            navController = navController,
            configuration = appToolbarConfig
        )
    }
}