package com.disneyherocompose.screens.preview

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.disneyherocompose.R
import com.disneyherocompose.navigation.LIST_HERO_SCREEN
import com.disneyherocompose.ui.theme.AppBack


@Composable
fun PreviewScreen(navController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(AppBack)
    ) {
        Text(
            modifier = Modifier
                .padding(start = 86.dp, top = 190.dp)
                .width(256.dp)
                .height(40.dp),
            color = Color.White,
            fontSize = 24.sp,
            text = stringResource(R.string.welcome_to_heroapp)
        )
        Image(
            bitmap = ImageBitmap.imageResource(R.drawable.preview_image),
            contentDescription = "previewImage",
            modifier = Modifier
                .padding(start = 44.dp, top = 360.dp)
                .width(370.dp)
                .height(230.dp)

        )
        Button(
            onClick = { navController.navigate(LIST_HERO_SCREEN) }, modifier = Modifier
                .padding(start = 20.dp, top = 740.dp)
                .width(374.dp)
                .height(64.dp)
        ) {
            Text(text = stringResource(R.string.get_started), fontSize = 16.sp)
        }
    }

}
