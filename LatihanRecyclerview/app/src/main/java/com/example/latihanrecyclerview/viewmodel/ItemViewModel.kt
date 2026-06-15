package com.example.latihanrecyclerview.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.latihanrecyclerview.R
import com.example.latihanrecyclerview.model.Item

class ItemViewModel : ViewModel() {

    private val _items = MutableLiveData<MutableList<Item>>()
    val items: LiveData<MutableList<Item>> get() = _items

    init {
        loadData()
    }

    private fun loadData() {
        _items.value = mutableListOf(
            Item(1, "Item Pertama",  "Deskripsi item kesatu",  R.drawable.gojo, false),
            Item(2, "Item Kedua",   "Deskripsi item kedua",   R.drawable.gojo2, false),
            Item(3, "Item Ketiga",  "Deskripsi item ketiga",  R.drawable.megumi, false),
            Item(4, "Item Keempat", "Deskripsi item keempat", R.drawable.yuji, false),
            Item(5, "Item Kelima",  "Deskripsi item kelima",  R.drawable.sukuna, false)
        )
    }

    fun updateSwitchState(index: Int, isActive: Boolean) {
        _items.value?.get(index)?.isActive = isActive
    }
}