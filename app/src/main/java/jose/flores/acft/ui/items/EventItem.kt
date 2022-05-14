package jose.flores.acft.ui.items

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.AbsoluteCutCornerShape
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Shapes
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import jose.flores.acft.Event

@Composable
fun EventItem(event: Event){
    Card(
        Modifier
            .fillMaxWidth()
            .height(100.dp)
            .padding(4.dp),
        shape = AbsoluteCutCornerShape(16.dp),
        backgroundColor = Color.DarkGray,
    ) {
        Icon(painter = painterResource(id = event.eventImage), contentDescription = "Event Image" )
    }
}