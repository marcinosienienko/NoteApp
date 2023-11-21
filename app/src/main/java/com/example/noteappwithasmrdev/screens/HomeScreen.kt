package com.example.noteappwithasmrdev.screens

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.lifecycle.viewmodel.compose.viewModel
import com.github.skydoves.colorpicker.compose.rememberColorPickerController

@Composable
fun HomeScreen(viewModel: HomeViewModel = viewModel()) {
    val notes by viewModel.notes.collectAsState()
    val searchedNotes by viewModel.searchedNotes.collectAsState()
    

    val (dialogOpen,setDialogOpen) = remember {
        mutableStateOf(false)
    }

    if (dialogOpen){
        val controller = rememberColorPickerController()
        controller.setWheelRadius(7.dp)
        val (note,setNote) = remember {
            mutableStateOf("")
        }
        
        val color by animateColorAsState(targetValue = controller.selectedColor.value)

        Dialog(onDismissRequest ={ setDialogOpen(false) }) {
            Column(modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(6.dp))
                .background(MaterialTheme.colorScheme.primary)
                .padding(
                    horizontal = 8.dp,
                    vertical = 12.dp)
            ) {

            }
        }
    }

    Scaffold(
        floatingActionButton = {FloatingActionButton(
            onClick = { /*TODO*/ },
            contentColor = Color.White,
            containerColor = MaterialTheme.colorScheme.secondary
        ) {
            Icon(
                Icons.Default.Add,
                contentDescription = null)
        }}

    ) { paddings ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    bottom = paddings.calculateBottomPadding(),
                    top = 18.dp,
                    start = 12.dp,
                    end = 12.dp
                )) {

        }
    }
}