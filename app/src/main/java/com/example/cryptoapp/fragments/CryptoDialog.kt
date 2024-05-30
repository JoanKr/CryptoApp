package com.example.cryptoapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.cryptoapp.databinding.DialogCryptoBinding
import com.example.cryptoapp.model.CryptoPriceEntity

class CryptoDialog(private val cryptoPrice: CryptoPriceEntity) : DialogFragment() {

    private var _binding: DialogCryptoBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = DialogCryptoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dialog?.window?.let {
            val width = (resources.displayMetrics.widthPixels * 0.9).toInt()
            it.setLayout(width, ViewGroup.LayoutParams.WRAP_CONTENT)
            it.setBackgroundDrawableResource(android.R.color.transparent)
        }
        binding.closeButton.setOnClickListener { dismiss() }
        showCryptoDetails()
    }

    private fun showCryptoDetails() {
        binding.cryptoName.text = cryptoPrice.id
        binding.cryptoPrice.text = cryptoPrice.priceUsd.toString()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
