package com.example.myfirstapp.second

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.myfirstapp.api.repository.Repository
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
    private val binding get() = _binding!!
    private lateinit var secondViewModel: SecondViewModel
    private lateinit var viewModelFactory: SecondViewModelFactory

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        viewModelFactory = SecondViewModelFactory(Repository())
        secondViewModel = ViewModelProvider(this, viewModelFactory).get(SecondViewModel::class.java)

        secondViewModel.response.observe(viewLifecycleOwner, {
            if(it != null)
                binding.textviewSecond.text = it.device_type + it.total + it.results[0].title
        })
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonSecond.setOnClickListener {
            val searchTerm = binding.editTextSearch.text.toString()
            secondViewModel.fetchGoogle()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}