package com.jtampinco.ticketmasterexplorer.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.jtampinco.ticketmasterexplorer.app.theme.shapes

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun SearchAppBar(
    query: String,
    onQueryChange: (String) -> Unit,
    onExecuteSearch: () -> Unit
) {
    val keyboard = LocalSoftwareKeyboardController.current
    Surface(
        modifier = Modifier.fillMaxWidth(),
        color = colors.primarySurface,
        elevation = 8.dp
    ) {
        Column {
            Row(modifier = Modifier.fillMaxWidth()) {
                TextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = query,
                    label = { Text(text = "Search") },
                    placeholder = { Text(text = "Input search query") },
                    colors = TextFieldDefaults.textFieldColors(
                        textColor = colors.onPrimary.copy(LocalContentAlpha.current),
                        placeholderColor = colors.onPrimary.copy(ContentAlpha.medium),
                        focusedLabelColor = colors.onPrimary.copy(alpha = ContentAlpha.high),
                        unfocusedLabelColor = colors.onPrimary.copy(ContentAlpha.medium),
                        cursorColor = colors.onPrimary
                    ),
                    shape = shapes.large,
                    singleLine = true,
                    maxLines = 1,
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Text,
                        imeAction = ImeAction.Search
                    ),
                    keyboardActions = KeyboardActions(onSearch = {
                        onExecuteSearch()
                        keyboard?.hide()
                    }),
                    leadingIcon = {
                        IconButton(
                            modifier = Modifier
                                .padding(horizontal = 8.dp)
                                .wrapContentWidth(Alignment.CenterHorizontally)
                                .align(Alignment.CenterVertically),
                            onClick = {
                                onExecuteSearch()
                                keyboard?.hide()
                            }
                        ) {
                            Icon(
                                imageVector = Icons.Filled.Search,
                                contentDescription = "Search",
                                tint = colors.onPrimary
                            )
                        }
                    },
                    onValueChange = { newValue -> onQueryChange(newValue) }
                )
            }
        }
    }
}