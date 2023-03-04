package com.example.s04e13

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.wear.tiles.material.Text
import com.example.s04e13.data.Datasource
import com.example.s04e13.modelo.Topic
import com.example.s04e13.ui.theme.S04E13Theme
import javax.sql.DataSource

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            S04E13Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    //Meeter aqui la caja exterior
                    CajaExterior()
                }
            }
        }
    }
}

@Composable
fun CajaExterior(modifier: Modifier = Modifier) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier.padding(8.dp)
    ) {
        items(Datasource.topics) { topic ->
            CajaInterior(topic)
        }
    }
}

@Composable
fun CajaInterior(topic: Topic, modifier: Modifier = Modifier) {
    Card {
        Row {
            //La Imagen
            Box {
                Image(
                    painter = painterResource(id = topic.imageRes),
                    contentDescription = null,
                    modifier = modifier
                        .size(width = 68.dp, height = 68.dp)
                        .aspectRatio(1f)
                )
            }
            //El Texto
            Column {
                Text(
                    text = stringResource(id = topic.name),
                    style = MaterialTheme.typography.body2,
                    modifier = Modifier.padding(
                        start = 16.dp,
                        top = 16.dp,
                        end = 16.dp,
                        bottom = 8.dp
                    )
                )
                Row(verticalAlignment = Alignment.CenterVertically) {

                    Icon(
                        painter = painterResource(id = R.drawable.ic_launcher_background),
                        contentDescription = null,
                        modifier = modifier.padding(start = 16.dp)
                    )
                    Text(
                        text = topic.availableCourses.toString(),
                        style = MaterialTheme.typography.caption,
                        modifier = Modifier.padding(start = 8.dp)
                    )

                }

            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun previewUnaTarjeta() {
    S04E13Theme {
        val topic = Topic(R.string.Actividad14, 118, R.drawable.tech)
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CajaInterior(topic = topic)
        }
    }
}