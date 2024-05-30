package com.example.cryptoapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cryptoapp.R
import com.example.cryptoapp.RetrofitClient
import com.example.cryptoapp.adapters.CryptoPriceAdapter
import com.example.cryptoapp.databinding.FragmentCryptoPriceListBinding
import com.example.cryptoapp.model.CryptoPriceEntity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CryptoPriceListFragment : Fragment() {

    private var _binding: FragmentCryptoPriceListBinding? = null
    private val binding get() = _binding!!
    private lateinit var cryptoPriceAdapter: CryptoPriceAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCryptoPriceListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        fetchCryptoPrices()
    }

    private fun setupRecyclerView() {
        cryptoPriceAdapter = CryptoPriceAdapter(mutableListOf())
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        binding.recyclerView.adapter = cryptoPriceAdapter
    }

    private fun fetchCryptoPrices() {
        RetrofitClient.apiService.getCryptoPrices().enqueue(object : Callback<Map<String, Map<String, Double>>> {
            override fun onResponse(call: Call<Map<String, Map<String, Double>>>, response: Response<Map<String, Map<String, Double>>>) {
                if (response.isSuccessful) {
                    response.body()?.let { cryptoPricesMap ->
                        val cryptoPrices = cryptoPricesMap.map { (id, priceMap) ->
                            CryptoPriceEntity(id, priceMap["usd"])
                        }
                        cryptoPriceAdapter.updateData(cryptoPrices)
                    }
                }
            }

            override fun onFailure(call: Call<Map<String, Map<String, Double>>>, t: Throwable) {
                Toast.makeText(requireContext(), getString(R.string.fetch_data_error_msg), Toast.LENGTH_SHORT).show()
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
