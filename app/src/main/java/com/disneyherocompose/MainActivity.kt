package com.disneyherocompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.disneyherocompose.navigation.MyNavHost
import com.disneyherocompose.repository.SharedPreferencesRepository
import com.disneyherocompose.ui.theme.DIsneyHeroComposeTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var sharedPreferenceRepository: SharedPreferencesRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DIsneyHeroComposeTheme {
                MyNavHost(rememberNavController())
            }
        }
    }
}