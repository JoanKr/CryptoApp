package com.example.cryptoapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cryptoapp.databinding.CryptoPriceListItemBinding
import com.example.cryptoapp.model.CryptoPriceEntity

class CryptoPriceAdapter(private val cryptoPrices: MutableList<CryptoPriceEntity>) : RecyclerView.Adapter<CryptoPriceAdapter.CryptoPriceViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CryptoPriceViewHolder {
        val binding = CryptoPriceListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CryptoPriceViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CryptoPriceViewHolder, position: Int) {
        val cryptoPrice = cryptoPrices[position]
        holder.bind(cryptoPrice)
    }

    override fun getItemCount(): Int = cryptoPrices.size

    fun updateData(newData: List<CryptoPriceEntity>) {
        cryptoPrices.clear()
        cryptoPrices.addAll(newData)
        notifyDataSetChanged()
    }

    inner class CryptoPriceViewHolder(private val binding: CryptoPriceListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(cryptoPrice: CryptoPriceEntity) {
            binding.cryptoName.text = cryptoPrice.id
            binding.cryptoPrice.text = cryptoPrice.priceUsd?.toString() ?: "N/A"
        }
    }
}
