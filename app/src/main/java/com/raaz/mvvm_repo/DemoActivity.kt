package com.raaz.mvvm_repo

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.raaz.mvvm_repo.ui.theme.MVVM_repoTheme
import com.raaz.mvvm_repo.ui.theme.viewmodel.FlowViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class DemoActivity: ComponentActivity() {
    val viewModel : FlowViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MVVM_repoTheme {

            }
        }
        observables()
        viewModel.getStateFlow()
        viewModel.getSharedFlow()
    }

    fun observables(){
        viewModel.liveData.observe(this){
            Toast.makeText(this,"$it",Toast.LENGTH_SHORT).show()
        }

        lifecycleScope.launch {
             lifecycle.repeatOnLifecycle(Lifecycle.State.RESUMED){
                 viewModel.stateFlow.collectLatest {
                     Toast.makeText(this@DemoActivity,"$it",Toast.LENGTH_SHORT).show()
                 }
             }
        }

        lifecycleScope.launch {
            lifecycle.repeatOnLifecycle(Lifecycle.State.RESUMED){
                viewModel.sharedFlow.collectLatest {
                    Toast.makeText(this@DemoActivity,"$it",Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}