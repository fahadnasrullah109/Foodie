package com.foodie.presentation.logout

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.foodie.R
import com.foodie.ui.theme.FoodieTheme

@Composable
fun LogoutDialog(
    onDismiss: () -> Unit, onConfirm: () -> Unit
) {
    AlertDialog(onDismissRequest = onDismiss,
        confirmButton = {
            TextButton(onClick = onConfirm) { Text(text = stringResource(id = R.string.action_logout_yes)) }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) { Text(text = stringResource(id = R.string.action_logout_no)) }
        },
        title = { Text(text = stringResource(id = R.string.label_logout)) },
        text = { Text(text = stringResource(id = R.string.label_logout_message)) })
}


@Preview
@Composable
fun LogoutDialogPreview() {
    FoodieTheme {
        LogoutDialog({}, {})
    }
}