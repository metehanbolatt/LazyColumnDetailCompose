package com.metehanbolat.lazycolumndetailcompose

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.metehanbolat.lazycolumndetailcompose.Movies.Companion.movies
import com.metehanbolat.lazycolumndetailcompose.ui.theme.LazyColumnDetailComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LazyColumnDetailComposeTheme {
                val context = LocalContext.current
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    LazyColumn {
                        items(movies) { movie ->
                            if (movie.subject == null) {
                                MoviesContent(movies = movie) {
                                    Toast.makeText(context, it.name, Toast.LENGTH_SHORT).show()
                                }
                            } else{
                                TitleContent(movies = movie) {
                                    Toast.makeText(context, "Title: ${movie.subject}", Toast.LENGTH_SHORT).show()
                                }.also {
                                    MoviesContent(movies = movie) {
                                        Toast.makeText(context, it.name, Toast.LENGTH_SHORT).show()
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun TitleContent(
    movies: Movies,
    onClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .background(Color.Magenta)
            .clickable { onClick() }
    ) {
        Text(
            text = movies.subject!!,
            color = Color.White,
            modifier = Modifier.padding(start = 12.dp, top = 6.dp, bottom = 6.dp, end = 6.dp)
        )
    }
}

@Composable
fun MoviesContent(
    movies: Movies,
    onClick: (Movies) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp)
            .background(Color.Black)
            .clickable { onClick(movies) }
    ){
        Text(
            text = movies.name,
            color = Color.White,
            modifier = Modifier.padding(6.dp)
        )
        Text(
            text = movies.year,
            color = Color.White,
            modifier = Modifier.padding(6.dp)
        )
    }
}

@Preview
@Composable
fun MoviesContentPreview() {
    MoviesContent(movies = Movies("Batman", "123")){}
}

@Preview
@Composable
fun TitleContentPreview() {
    TitleContent(movies = Movies("Interstellar", "2311", "Drama")){}
}