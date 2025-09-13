package com.stellacr.scasillascoinsphere.ui.theme

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.stellacr.scasillascoinsphere.ui.theme.Surface

val Background = Color(0xFF0B1020)
val Surface = Color(0xFF151B2E)
val TextMain = Color(0xFFE8ECF8)
val TextDim = Color(0xFF9AA3B2)

data class CryptoM(val nombre: String, val precio: String, val urlImagen: String)

@Composable
fun AppCoinSphere(){
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Background
    ) {
        HomeScreen()
    }
}

fun HomeScreen(){
    val listaCrypto = listOf(
        CryptoM("Bitcoin", "$34353", "sad")
    )
}

@Preview(showBackground = true)
@Composable
private fun PreviewNews() {
    SCasillasCoinSphereTheme {
        HomeScreen()
    }
}
