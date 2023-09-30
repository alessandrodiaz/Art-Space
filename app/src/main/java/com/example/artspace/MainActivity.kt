package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                // A surface container using the 'background' color from the theme

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = colorResource(id = R.color.clay)
                ) {
                    ArtSpaceScreen()
                }
            }
        }
    }
}

data class ArtworkInfo(val title: Int, val year: Int, val description: Int, val image: Int)

@Composable
fun ArtSpaceScreen(modifier: Modifier = Modifier) {

    var currentArtwork by remember { mutableStateOf(1) }
    var maxArtwork = 10

    val artworkInfo = when (currentArtwork) {
        1 -> ArtworkInfo(
            R.string.small_beto,
            R.string.small_beto_year,
            R.string.small_beto_description,
            R.drawable.small_beto
        )

        2 -> ArtworkInfo(
            R.string.beto,
            R.string.beto_year,
            R.string.beto_description,
            R.drawable.beto
        )

        3 -> ArtworkInfo(
            R.string.little_bruno,
            R.string.little_bruno_year,
            R.string.little_bruno_description,
            R.drawable.small_bruno
        )

        4 -> ArtworkInfo(
            R.string.bruno,
            R.string.bruno_year,
            R.string.bruno_description,
            R.drawable.bruno
        )

        5 -> ArtworkInfo(
            R.string.vetusta_morla,
            R.string.vetusta_morla_year,
            R.string.vetusta_morla_description,
            R.drawable.vetusta_morla
        )

        6 -> ArtworkInfo(
            R.string.half_alive,
            R.string.half_alive_year,
            R.string.half_alive_description,
            R.drawable.half_alive
        )

        7 -> ArtworkInfo(
            R.string.weeknd,
            R.string.weeknd_year,
            R.string.weeknd_description,
            R.drawable.weeknd
        )

        8 -> ArtworkInfo(
            R.string.asphalt,
            R.string.asphalt_year,
            R.string.asphalt_description,
            R.drawable.asphalt
        )

        9 -> ArtworkInfo(
            R.string.cities_skylines,
            R.string.cities_skylines_year,
            R.string.cities_skylines_description,
            R.drawable.cities_skylines
        )

        10 -> ArtworkInfo(
            R.string.breaking_bad,
            R.string.breaking_bad_year,
            R.string.breaking_bad_description,
            R.drawable.breaking_bad
        )

        else -> ArtworkInfo(
            R.string.breaking_bad,
            R.string.breaking_bad_year,
            R.string.breaking_bad_description,
            R.drawable.breaking_bad
        )
    }


    val incrementArtwork: () -> Unit = {
        //currentArtwork = (currentArtwork % 10) + 1
        if (currentArtwork < maxArtwork) {
            currentArtwork += 1
        }
    }

    val decreaseArtwork: () -> Unit = {
        if (currentArtwork > 1) {
            currentArtwork -= 1
        }
    }

    val restartArtwork: () -> Unit = {
        currentArtwork = 1
    }

    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Spacer(
            modifier = modifier.size(30.dp)
        )

        Text(
            text = stringResource(R.string.my_name_code),
            fontSize = 18.sp
        )

        ArtworkImage(
            currentArtwork = artworkInfo.image
        )
        Spacer(
            modifier = modifier.size(16.dp)
        )
        ArtworkTitle(
            title = artworkInfo.title,
            year = artworkInfo.year,
            description = artworkInfo.description,
        )
        Spacer(
            modifier = modifier.size(45.dp)
        )
        Row(
            modifier = modifier
                .padding(horizontal = 10.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            // BUTTON PREVIOUS --------------------------------------------------------------------
            Button(
                onClick = decreaseArtwork,

                colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.dark_clay)),

                modifier = Modifier.width(125.dp),
                elevation = ButtonDefaults.elevatedButtonElevation(
                    defaultElevation = 1.dp,
                    pressedElevation = 0.dp,
                    focusedElevation = 0.dp,
                )
            ) {
                Text(
                    text = stringResource(R.string.previous_button),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                    color = colorResource(id = R.color.white)
                )
            }

            // BUTTON RESTART----------------------------------------------------------------------
            IconButton(
                onClick = restartArtwork,
                modifier = Modifier
                    .size(55.dp)  // Ajusta el tamaño según sea necesario
                    .clip(CircleShape)
                    .background(colorResource(id = R.color.dark_clay))
                    .padding(8.dp),  // Ajusta el relleno según sea necesario

            ) {
                Icon(
                    painter = painterResource(id = R.drawable.icons8_restart_100),  // Cambia a tu icono de restart
                    contentDescription = null,  // Aquí puedes agregar una descripción si es necesario
                    tint = colorResource(id = R.color.white)  // Cambia el color del icono si es necesario
                )
            }

            //BUTTON NEXT -------------------------------------------------------------------------
            Button(
                onClick = incrementArtwork,
                colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.dark_clay)),
                modifier = Modifier.width(125.dp),
                elevation = ButtonDefaults.elevatedButtonElevation(
                    defaultElevation = 1.dp,
                    pressedElevation = 0.dp,
                    focusedElevation = 0.dp
                ),
            ) {
                Text(
                    text = stringResource(R.string.next_button),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                    color = colorResource(id = R.color.white)
                )
            }
        }

        Spacer(
            modifier = modifier.size(30.dp)
        )


    }
}


@Composable
fun PreviousButton() {

}

@Composable
fun ArtworkImage(
    modifier: Modifier = Modifier,
    @DrawableRes currentArtwork: Int
) {
    Image(
        painter = painterResource(id = currentArtwork),
        contentDescription = null,
        modifier = Modifier
            .fillMaxWidth()
            .padding(50.dp)
            .shadow(40.dp)
            .clip(shape = RoundedCornerShape(40.dp))
            .border(2.dp, Color.Black, shape = RoundedCornerShape(40.dp)),
        contentScale = ContentScale.FillWidth
    )
}

@Composable
fun ArtworkTitle(
    @StringRes title: Int,
    @StringRes year: Int,
    @StringRes description: Int,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(id = title),
            fontWeight = FontWeight.Bold,
            color = colorResource(id = R.color.dark_clay),
            fontSize = 32.sp,
        )
        Text(
            text = stringResource(id = year),
            fontWeight = FontWeight.Medium,
            color = colorResource(id = R.color.dark_clay),
            fontSize = 16.sp,
        )
        Text(
            text = stringResource(id = description),
            fontWeight = FontWeight.Normal,
            color = colorResource(id = R.color.black),
            fontSize = 16.sp,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ArtSpaceTheme {
        ArtSpaceScreen()
    }
}

