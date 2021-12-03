package com.example.myfirstapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.myfirstapp.databinding.FragmentSecondBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.Response

import okhttp3.OkHttpClient
import okhttp3.Request


/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonSecond.setOnClickListener {

            viewLifecycleOwner.lifecycleScope.launch (Dispatchers.IO) {
                val client = OkHttpClient()

                val request = Request.Builder()
                    .url("https://google-search3.p.rapidapi.com/api/v1/search/q=elon+musk&num=100")
                    .get()
                    .addHeader("x-user-agent", "desktop")
                    .addHeader("x-proxy-location", "US")
                    .addHeader("x-rapidapi-host", "google-search3.p.rapidapi.com")
                    .addHeader("x-rapidapi-key", "7d46b461dfmsh6e22844b5beb80ep1789f9jsn05189fc8fe2a")
                    .build()

                val response = client.newCall(request).execute()

                activity?.runOnUiThread {
                    var textView = view.findViewById<TextView>(R.id.textview_second)
                    textView.text = response.message
                }

            }

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}