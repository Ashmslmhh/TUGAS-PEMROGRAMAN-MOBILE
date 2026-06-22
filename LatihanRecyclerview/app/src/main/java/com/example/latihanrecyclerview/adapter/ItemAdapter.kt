package com.example.latihanrecyclerview.adapter

import android.content.res.ColorStateList
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.latihanrecyclerview.R
import com.example.latihanrecyclerview.databinding.ItemsBinding
import com.example.latihanrecyclerview.model.Item

class ItemAdapter(
    private val items: MutableList<Item>,
    private val onSwitchChanged: (Int, Boolean) -> Unit,
    private val onButtonClicked: (Int) -> Unit
) : RecyclerView.Adapter<ItemAdapter.ViewHolder>() {

    class ViewHolder(val binding: ItemsBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        val context = holder.itemView.context

        if (position % 2 == 0) {
            holder.binding.cardContainer.setCardBackgroundColor(
                ContextCompat.getColor(context, R.color.white)
            )
        } else {
            holder.binding.cardContainer.setCardBackgroundColor(
                ContextCompat.getColor(context, R.color.green_pastel)
            )
        }

        holder.binding.tvTitle.text = item.name
        holder.binding.tvDesc.text = item.description
        holder.binding.imgItem.setImageResource(item.imageRes)

        holder.binding.switchItem.setOnCheckedChangeListener(null)
        holder.binding.switchItem.isChecked = item.isActive
        updateSwitchColor(holder)

        holder.binding.switchItem.setOnCheckedChangeListener { _, isChecked ->
            item.isActive = isChecked
            updateSwitchColor(holder)
            onSwitchChanged(position, isChecked)
        }

        holder.binding.btnAksi.setOnClickListener {
            onButtonClicked(position)
        }
    }

    private fun updateSwitchColor(holder: ViewHolder) {
        val context = holder.itemView.context
    }

    fun updateItem(index: Int, isActive: Boolean) {
        items[index].isActive = isActive
        notifyItemChanged(index)
    }

    override fun getItemCount(): Int = items.size
}