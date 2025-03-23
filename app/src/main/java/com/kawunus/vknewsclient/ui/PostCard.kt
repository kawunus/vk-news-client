package com.kawunus.vknewsclient.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.MoreVert
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp
import com.kawunus.vknewsclient.R
import com.kawunus.vknewsclient.ui.theme.VkNewsClientTheme

@Composable
fun PostCard() {
    Card(
        colors = CardDefaults.cardColors(MaterialTheme.colorScheme.primary)
    ) {
        Column(
            modifier = Modifier
                .padding(8.dp)
        ) {
            PostCardHeader()
            Spacer(
                modifier = Modifier
                    .height(8.dp)
            )
            PostCardBody()
            Spacer(
                modifier = Modifier
                    .height(8.dp)
            )
            Statistics()
        }
    }
}

@Composable
private fun PostCardHeader() {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Image(
            modifier = Modifier
                .size(50.dp)
                .clip(CircleShape),
            painter = painterResource(R.drawable.placeholder_avatar),
            contentDescription = null
        )
        Spacer(
            modifier = Modifier
                .width(8.dp)
        )
        Column(
            modifier = Modifier
                .weight(1f)
        ) {
            Text(
                text = "/dev/null",
                color = MaterialTheme.colorScheme.onPrimary
            )
            Spacer(
                modifier = Modifier
                    .height(4.dp)
            )
            Text(
                text = "14:00",
                color = MaterialTheme.colorScheme.onSecondary
            )
        }
        Icon(
            imageVector = Icons.Rounded.MoreVert,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.onSecondary
        )
    }
}

@Composable
private fun PostCardBody() {
    Text(
        text = LoremIpsum(
            words = 8
        )
            .values
            .toList()
            .first()
            .toString(),
        color = MaterialTheme.colorScheme.onPrimary
    )

    Spacer(
        modifier = Modifier
            .height(8.dp)
    )

    Image(
        painter = painterResource(R.drawable.placeholder_content),
        contentDescription = null,
        modifier = Modifier
            .fillMaxWidth(),
        contentScale = ContentScale.FillWidth
    )
}

@Composable
private fun Statistics() {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            modifier = Modifier
                .weight(1f)
        ) {
            IconWithText(
                iconResId = R.drawable.ic_views_count,
                text = "916"
            )
        }
        Row(
            modifier = Modifier
                .weight(1f),
            horizontalArrangement = Arrangement.Absolute.SpaceBetween
        ) {
            IconWithText(
                iconResId = R.drawable.ic_share,
                text = "7"
            )
            IconWithText(
                iconResId = R.drawable.ic_comment,
                text = "8"
            )
            IconWithText(
                iconResId = R.drawable.ic_like,
                text = "23"
            )
        }
    }
}

@Composable
private fun IconWithText(
    iconResId: Int,
    text: String
) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(iconResId),
            contentDescription = null,
            tint = MaterialTheme.colorScheme.onSecondary
        )
        Spacer(
            modifier = Modifier
                .padding(4.dp)
        )
        Text(
            text = text,
            color = MaterialTheme.colorScheme.onSecondary
        )
    }
}

@Composable
@Preview
private fun PreviewLight() {
    VkNewsClientTheme(
        darkTheme = false
    ) {
        PostCard()
    }
}

@Composable
@Preview
private fun PreviewDark() {
    VkNewsClientTheme(
        darkTheme = true
    ) {
        PostCard()
    }
}