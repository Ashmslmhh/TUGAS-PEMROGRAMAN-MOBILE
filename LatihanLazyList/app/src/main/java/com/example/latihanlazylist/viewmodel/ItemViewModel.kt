package com.example.latihanlazylist.viewmodel

import androidx.lifecycle.ViewModel
import androidx.compose.runtime.mutableStateListOf
import com.example.latihanlazylist.model.Item
import com.example.latihanlazylist.R

class ItemViewModel : ViewModel() {

    val items = mutableStateListOf(
        Item(1, "Item Pertama",  "Deskripsi item kesatu",  R.drawable.gojo,   false),
        Item(2, "Item Kedua",   "Deskripsi item kedua",   R.drawable.gojo2,  false),
        Item(3, "Item Ketiga",  "Deskripsi item ketiga",  R.drawable.megumi, false),
        Item(4, "Item Keempat", "Deskripsi item keempat", R.drawable.yuji,   false),
        Item(5, "Item Kelima",  "Deskripsi item kelima",  R.drawable.sukuna, false)
    )

    fun updateSwitchState(index: Int, isActive: Boolean) {
        items[index] = items[index].copy(isActive = isActive)
    }
}