package com.bertosoft.incidencias.ui.add

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.GridLayoutManager
import com.bertosoft.incidencias.databinding.FragmentAddBinding
import com.bertosoft.incidencias.ui.add.adapter.AddAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class addFragment : Fragment() {

    private val addViewModel by viewModels<AddViewModel>()
    private lateinit var addAdapter: AddAdapter
    private var _binding: FragmentAddBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initUi()
    }

    private fun initUi() {
        initRv()
        initUiState()
    }

    private fun initRv() {
        addAdapter = AddAdapter()

        binding.rvAdd.apply {
            layoutManager = GridLayoutManager(context, 2)
            adapter = addAdapter
        }
    }

    private fun initUiState() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                addViewModel.addDatos.collect {
                    //
                    // Ha habido cambios en addDatos
                    //
                    addAdapter.refrescaLista(it)
                }
            }
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentAddBinding.inflate(layoutInflater)
        return binding.root
    }

}