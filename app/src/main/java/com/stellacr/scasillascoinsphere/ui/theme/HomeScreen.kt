package com.stellacr.scasillascoinsphere.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage

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
        CryptoM("Bitcoin", "$109,797.37", "https://cryptologos.cc/logos/bitcoin-btc-logo.png"),
        CryptoM("Ethereum", "$4,321.21", "https://cryptologos.cc/logos/ethereum-eth-logo.png"),
        CryptoM("Tether", "$1.0000", "https://cryptologos.cc/logos/tether-usdt-logo.png"),
        CryptoM("XRP", "$2.8100", "https://cryptologos.cc/logos/xrp-xrp-logo.png"),
        CryptoM("BNB", "$845.00", "https://cryptologos.cc/logos/bnb-bnb-logo.png"),
        CryptoM("Solana", "$201.85", "https://cryptologos.cc/logos/solana-sol-logo.png"),
        CryptoM("USDC", "$0.9998", "https://cryptologos.cc/logos/usd-coin-usdc-logo.png"),
        CryptoM("Dogecoin", "$0.1320", "https://cryptologos.cc/logos/dogecoin-doge-logo.png"),
        CryptoM("TRON", "$0.3630", "https://cryptologos.cc/logos/tron-trx-logo.png")
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

        Card(titulo = "Global Market Cap", valor = "$2.18T")
        Card(titulo = "Fear & Greed", valor = "Neutral (54)")
        Card(titulo = "Altcoin Season", valor = "No")

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn {
            itemsIndexed(listaCrypto) { indice, crypto ->
                ItemCrypto(posicion = indice + 1, crypto = crypto)
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

@Composable
fun ItemCrypto(posicion: Int, crypto: CryptoM) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Surface, shape = RoundedCornerShape(12.dp))
            .padding(12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "$posicion",
            color = TextDim,
            modifier = Modifier.width(24.dp),
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.width(8.dp))

        AsyncImage(
            model = crypto.urlImagen,
            contentDescription = crypto.nombre,
            modifier = Modifier.size(32.dp),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.width(12.dp))

        Text(
            text = crypto.nombre,
            color = TextMain,
            modifier = Modifier.weight(1f)
        )

        Text(
            text = crypto.precio,
            color = TextMain
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewNews() {
    SCasillasCoinSphereTheme {
        HomeScreen()
    }
}
