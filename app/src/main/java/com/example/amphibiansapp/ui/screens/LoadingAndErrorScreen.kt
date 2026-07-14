package com.example.amphibiansapp.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.amphibiansapp.R
import com.example.amphibiansapp.ui.theme.AmphibiansAppTheme
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource

@Composable
private fun ErrorOrLoading(
    text: String,
    iconId: Int,
    modifier: Modifier
){
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ){
        Text(
            text = text,
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(Modifier.padding(dimensionResource(R.dimen.padding_small)))

        Icon(
            painter = painterResource(iconId),
            "sad emoji",
            modifier = Modifier.size(dimensionResource(R.dimen.icon_size))
        )
    }
}
@Composable
fun ErrorScreen(
    retryAction: () -> Unit,
    errorText: String
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.statusBarsPadding()
    ){
        ErrorOrLoading(
            text = errorText,
            iconId = R.drawable.ic_connection_error,
            modifier = Modifier
                .padding(dimensionResource(R.dimen.padding_small))
                .fillMaxSize()
                .weight(1f)
        )

        Button(onClick = retryAction) {
            Text(stringResource(R.string.retry))
        }

        Spacer(Modifier.weight(1f))
    }
}

@Composable
fun LoadingScreen() = ErrorOrLoading(
    text = stringResource(R.string.loading),
    iconId = R.drawable.loading,
    modifier = Modifier
        .statusBarsPadding()
        .padding(dimensionResource(R.dimen.padding_small))
        .fillMaxSize()
)

@Preview(showBackground = true)
@Composable
fun ErrorScreenPreview(){
    AmphibiansAppTheme {
        ErrorScreen({},"No internet connection")
    }
}

@Preview(showBackground = true)
@Composable
fun LoadingScreenPreview(){
    AmphibiansAppTheme {
        LoadingScreen()
    }
}