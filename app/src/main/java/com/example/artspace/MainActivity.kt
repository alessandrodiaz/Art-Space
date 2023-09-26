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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
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

@Composable
fun ArtSpaceScreen(modifier: Modifier = Modifier) {

    val firstArtwork = R.drawable.denji_face
    val secondArtwork = R.drawable.zero_two_face
    val thirdArtwork = R.drawable.sanji_face
    val fourthArtwork = R.drawable.naruto_face

    var title by remember { mutableStateOf(R.string.denji) }
    var year by remember { mutableStateOf(R.string.denji_year) }
    var currentArtwork by remember { mutableStateOf(firstArtwork) }
    var imageResource by remember { mutableStateOf(currentArtwork) }



    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ){
        ArtworkImage(
            currentArtwork = currentArtwork
        )
        Spacer(
            modifier = modifier.size(16.dp)
        )
        ArtworkTitle(
            title = title,
            year = year,
        )
        Spacer(
            modifier = modifier.size(25.dp)
        )
        Row(
            modifier = modifier.padding(horizontal = 8.dp).fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            // BUTTON PREVIOUS --------------------------------------------------------------------
            Button(
                onClick = {
                    when (currentArtwork) {
                        firstArtwork -> {
                            currentArtwork = fourthArtwork
                            title = R.string.naruto
                            year = R.string.naruto_year
                        }
                        secondArtwork -> {
                            currentArtwork = firstArtwork
                            title = R.string.denji
                            year = R.string.denji_year
                        }
                        thirdArtwork -> {
                            currentArtwork = thirdArtwork
                            title = R.string.zero_two
                            year = R.string.zero_two_year
                        }
                        else -> {
                            currentArtwork = thirdArtwork
                            title = R.string.sanji
                            year = R.string.sanji_year
                        }
                    }
                },

                colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.dark_clay)),

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
            //BUTTON NEXT -------------------------------------------------------------------------
            Button(
                onClick = {
                    when (currentArtwork) {
                        firstArtwork -> {
                            currentArtwork = secondArtwork
                            title = R.string.zero_two
                            year = R.string.zero_two_year
                        }
                        secondArtwork -> {
                            currentArtwork = thirdArtwork
                            title = R.string.sanji
                            year = R.string.sanji_year
                        }
                        thirdArtwork -> {
                            currentArtwork = fourthArtwork
                            title = R.string.naruto
                            year = R.string.naruto_year
                        }
                        else -> {
                            currentArtwork = firstArtwork
                            title = R.string.denji
                            year = R.string.denji_year
                        }
                    }
                },
                colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.dark_clay)),

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
    }
}


@Composable
fun PreviousButton(){

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
            .border(2.dp, Color.Black,shape = RoundedCornerShape(40.dp)),
        contentScale = ContentScale.FillWidth
    )
}

@Composable
fun ArtworkTitle(
    @StringRes title: Int,
    @StringRes year: Int,
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
            color = colorResource(id = R.color.gray_300),
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

