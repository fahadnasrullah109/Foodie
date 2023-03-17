package com.foodie.presentation.landing

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.foodie.R
import com.foodie.components.FoodieWhiteButton
import com.foodie.ui.theme.FoodieTheme

@Composable
fun LandingScreen(modifier: Modifier = Modifier, onGetStartedSelected: () -> Unit) {
    Surface(modifier = modifier, color = MaterialTheme.colorScheme.primary) {
        ConstraintLayout(modifier = modifier.padding(all = 20.dp)) {
            val (topIcon, landingText, characterIcon, button) = createRefs()
            Image(
                modifier = Modifier.constrainAs(topIcon) {
                    top.linkTo(parent.top, margin = 16.dp)
                }.size(50.dp),
                painter = painterResource(id = R.drawable.ic_landing_top),
                contentDescription = "landing top icon"
            )
            Text(
                modifier = Modifier.constrainAs(landingText) {
                    top.linkTo(topIcon.bottom, margin = 10.dp)
                },
                text = stringResource(id = R.string.food_for_everyone_label),
                style = TextStyle(color = Color.White,fontSize = 50.sp , fontWeight = FontWeight.Black)
            )
            Image(
                modifier = Modifier.constrainAs(characterIcon) {
                    bottom.linkTo(button.top, 20.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }.size(250.dp),
                painter = painterResource(id = R.drawable.ic_landing_bottom),
                contentDescription = "landing top bottom"
            )
            FoodieWhiteButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .constrainAs(button) {
                        bottom.linkTo(parent.bottom, 16.dp)
                    },
                text = stringResource(id = R.string.get_started_label),
                onClick = onGetStartedSelected
            )
        }
    }
}

@Preview
@Composable
fun LandingScreenPreview() {
    FoodieTheme {
        LandingScreen(modifier = Modifier.fillMaxSize()) {

        }
    }
}