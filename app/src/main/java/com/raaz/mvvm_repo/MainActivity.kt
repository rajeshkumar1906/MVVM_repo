package com.raaz.mvvm_repo

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.dp
import com.raaz.data.Root
import com.raaz.mvvm_repo.ui.theme.MVVM_repoTheme
import com.raaz.mvvm_repo.ui.theme.viewmodel.BaseAPIViewModel
import dagger.hilt.android.AndroidEntryPoint
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.livedata.observeAsState
import com.raaz.mvvm_repo.ui.theme.ShowOpenLibScreen
import com.raaz.mvvm_repo.ui.theme.viewmodel.OpenLibViewModel

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel: BaseAPIViewModel by viewModels()
    private val openLibViewModel: OpenLibViewModel by viewModels()
    @OptIn(ExperimentalFoundationApi::class, ExperimentalUnitApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MVVM_repoTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { paddingValues ->
//                    showLibData(openLibViewModel,Modifier.padding(paddingValues))
                    ShowOpenLibScreen(openLibViewModel,Modifier.padding(paddingValues))
                }
            }
        }
        openLibViewModel.error.observe(this){
            Log.e("Main Activity","Error $it")
        }

    }
}


@ExperimentalFoundationApi
@Composable
private fun showLibData(openLibViewModel: OpenLibViewModel,modifier: Modifier){
    LaunchedEffect(key1 = Unit) {
        openLibViewModel.getLibResponse()
    }
    val data = openLibViewModel.libResponse.observeAsState()
    data.value?.docs?.let {
        LazyColumn(
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 16.dp),
            verticalArrangement = Arrangement.spacedBy(3.dp),
        ) {
            item {
                Text(text = "I'm header.")
            }
            items(items = it) { item ->
                item?.title?.let {
                    Greeting(it,modifier)
                }
            }
            // footer
            item {
                Text(
                    text = "I'm footer.",
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}



@ExperimentalFoundationApi
@OptIn(ExperimentalAnimationApi::class)
@ExperimentalUnitApi
@Composable
private fun Observables(viewModel: BaseAPIViewModel, modifier: Modifier = Modifier) {


    LaunchedEffect(key1 = Unit) {
        viewModel.getResponse()
    }

    val data =  viewModel.apiResponse.observeAsState()

    data.value?.let {
        LazyColumn(
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 16.dp),
            verticalArrangement = Arrangement.spacedBy(3.dp),
        ) {
            item {
                Text(text = "I'm header.")
            }
            items(items = it) { item ->
                item.name?.let {
                    Greeting(it,modifier)
                }
            }
            // footer
            item {
                Text(
                    text = "I'm footer.",
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MVVM_repoTheme {
        Greeting("Android")
    }
}