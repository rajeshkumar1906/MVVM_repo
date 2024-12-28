package com.raaz.mvvm_repo.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import com.raaz.domain.model.openlib.DocX
import com.raaz.mvvm_repo.Greeting
import com.raaz.mvvm_repo.R
import com.raaz.mvvm_repo.ui.theme.viewmodel.OpenLibViewModel

@Composable
fun ShowOpenLibScreen(openLibViewModel: OpenLibViewModel, modifier: Modifier){
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
                Text(text = "I'm header.", Modifier.padding(end = 20.dp,top=20.dp)
                )
            }
            items(items = it) { item ->
                item?.title?.let {
//                    Greeting(it,modifier)
                    ShowListItem(item)
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
private fun ShowListItem(item: DocX){
    Card(modifier = Modifier.fillMaxSize().padding(start = 20.dp, end = 20.dp, top = 5.dp),
        shape = RectangleShape) {
        Row(Modifier.fillMaxSize()) {
            ImageView()
            Spacer(modifier = Modifier.padding(horizontal = 10.dp))
            Column (modifier = Modifier.padding(top = 3.dp)) {
                Text("Title: ${item.title}")
                if (item.authorName.isNotEmpty()) {
                    Text("Author: ${item.authorName[0]}", modifier = Modifier.padding(top=3.dp))
                }
            }
        }
    }

}

@Composable
private fun ImageView() {
    Card(
        modifier = Modifier.size(48.dp),
        shape = CircleShape
    ) {
        Image(
            painterResource(android.R.drawable.ic_menu_camera),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
    }
}