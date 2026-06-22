package com.example.latihanrecyclerview

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.latihanrecyclerview.adapter.ItemAdapter
import com.example.latihanrecyclerview.databinding.ActivityMainBinding
import com.example.latihanrecyclerview.viewmodel.ItemViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: ItemAdapter
    private val viewModel: ItemViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecyclerView()
        observeData()
    }

    private fun setupRecyclerView() {
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
    }

    private fun observeData() {
        viewModel.items.observe(this) { itemList ->
            adapter = ItemAdapter(
                items = itemList,
                onSwitchChanged = { index, isActive ->
                    viewModel.updateSwitchState(index, isActive)
                    adapter.updateItem(index, isActive)
                    if (isActive) {
                        Toast.makeText(
                            this,
                            "Switch hidup pada item ${index + 1}",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                },
                onButtonClicked = { index ->
                    Toast.makeText(
                        this,
                        "Tombol telah ditekan untuk tombol ${index + 1}",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            )
            binding.recyclerView.adapter = adapter
        }
    }
}