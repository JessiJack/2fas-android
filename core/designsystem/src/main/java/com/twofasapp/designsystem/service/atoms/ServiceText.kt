package com.twofasapp.designsystem.service.atoms

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.twofasapp.designsystem.TwTheme
import com.twofasapp.designsystem.service.ServiceStyle
import com.twofasapp.locale.TwLocale

@Composable
internal fun ServiceName(
    text: String,
    modifier: Modifier = Modifier,
    textStyles: ServiceTextStyle = ServiceTextDefaults.default(),
) {
    Text(
        text = text,
        style = textStyles.nameTextStyle,
        color = TwTheme.color.onSurfacePrimary,
        maxLines = 1,
        overflow = TextOverflow.Ellipsis,
        modifier = modifier.padding(bottom = 2.dp),
    )
}


@Composable
internal fun ServiceInfo(
    text: String?,
    style: ServiceStyle = ServiceStyle.Default,
    spacer: Boolean = true,
    modifier: Modifier = Modifier,
    textStyles: ServiceTextStyle = ServiceTextDefaults.default(),
) {
    if (text.isNullOrEmpty().not()) {
        Text(
            text = text!!,
            style = textStyles.infoTextStyle,
            color = TwTheme.color.onSurfaceSecondary,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = modifier,
        )
    }

    if (spacer) {
        Spacer(
            Modifier.size(
                when (style) {
                    ServiceStyle.Default -> 12.dp
                    ServiceStyle.Compact -> 2.dp
                }
            )
        )
    }
}

@Preview
@Composable
private fun Preview() {
    Column {
        ServiceName(text = TwLocale.strings.placeholder, modifier = Modifier.fillMaxWidth())
        ServiceInfo(text = TwLocale.strings.placeholderMedium, modifier = Modifier.fillMaxWidth(), style = ServiceStyle.Default)
    }
}