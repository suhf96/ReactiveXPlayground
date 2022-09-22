package hu.gyuriczaadam.reactivexpalygorund.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import hu.gyuriczaadam.reactivexpalygorund.presentation.main_screen.MainViewModel
import hu.gyuriczaadam.reactivexpalygorund.presentation.main_screen.components.PostItem

@Composable
fun MainScreen(
    navController: NavController,
    viewModel: MainViewModel
) {
    val state = viewModel.state
    Box(
        modifier = Modifier.fillMaxSize(),
    ) {
        Column(  modifier = Modifier
            .fillMaxSize()
            .padding(18.dp)) {

            Row(modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(text = "Flatmap playgorund", textAlign = TextAlign.Center, fontSize = 20.sp)
                /*Button(onClick = { /*TODO*/ }) {
                    
                }*/
            }
            Spacer(modifier = Modifier.height(20.dp))
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                items(state.posts){posts->
                    PostItem(post = posts!!)
                }
            }

        }
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        when {
            state.isLoading -> CircularProgressIndicator()
            state.error.isNotBlank() ->{
                Text(
                    text = state.error,
                    style = MaterialTheme.typography.body1,
                    textAlign = TextAlign.Center
                )
            }
            state.posts.isEmpty()->{
                Text(
                    text = "No results",
                    style = MaterialTheme.typography.body1,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}