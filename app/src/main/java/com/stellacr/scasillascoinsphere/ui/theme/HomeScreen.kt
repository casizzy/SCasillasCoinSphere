package com.stellacr.scasillascoinsphere.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

val Background = Color(0xFF0B1020)
val Surface = Color(0xFF151B2E)
val TextMain = Color(0xFFE8ECF8)
val TextDim = Color(0xFF9AA3B2)

data class CryptoM(val nombre: String, val precio: String, val urlImagen: String)

@Composable
fun SCasillasCoinSphereTheme(content: @Composable () -> Unit) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Background
    ) {
        content()
    }
}

@Composable
fun HomeScreen(){
    val listaCrypto = listOf(
        CryptoM("Bitcoin", "$34353", "sad")
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "CoinSphere",
            color = TextMain,
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(16.dp))

        Card(titulo = "Capitalización Global", valor = "$2.18T")
        Card(titulo = "Índice de Miedo y Codicia", valor = "Neutral (54)")
        Card(titulo = "Temporada de Altcoins", valor = "No")

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn {
            itemsIndexed(listaCrypto) { indice, crypto ->
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }
}

@Composable
fun Card(titulo: String, valor: String) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Surface, shape = RoundedCornerShape(12.dp))
            .padding(16.dp)
            .padding(bottom = 10.dp)
    ) {
        Column {
            Text(titulo, color = TextDim, style = MaterialTheme.typography.bodySmall)
            Text(valor, color = TextMain, style = MaterialTheme.typography.bodyLarge)
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewNews() {
    SCasillasCoinSphereTheme {
        HomeScreen()
    }
}
