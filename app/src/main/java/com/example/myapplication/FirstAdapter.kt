package com.example.myapplication

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.myapplication.databinding.ItemFirstBinding

class FirstAdapter(private val list:ArrayList<FirstModel>,private var onClick:(pos:Int)->Unit): Adapter<FirstAdapter.FirsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FirsViewHolder {
        return FirsViewHolder(ItemFirstBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: FirsViewHolder, position: Int) {
        holder.bind(list[position])
        holder.itemView.setOnClickListener {
            onClick(position)
        }
    }

    override fun getItemCount(): Int = list.size

    inner class FirsViewHolder(private val binding: ItemFirstBinding) :ViewHolder(binding.root) {
        fun bind(firstModel: FirstModel) {
            binding.image.setImageResource(firstModel.image)
            binding.name.text = firstModel.name
        }
    }
}