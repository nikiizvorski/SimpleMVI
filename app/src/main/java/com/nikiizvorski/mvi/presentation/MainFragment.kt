package com.nikiizvorski.mvi.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.nikiizvorski.mvi.databinding.FragmentMainBinding
import com.nikiizvorski.mvi.entity.Photo
import com.nikiizvorski.mvi.util.DataState
import com.nikiizvorski.mvi.presentation.StateEvent.*
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
@AndroidEntryPoint
class MainFragment: Fragment() {
    private lateinit var binding: FragmentMainBinding
    var photoListAdapter: PhotoListAdapter = PhotoListAdapter()
    private val viewModel: MainViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
        initViewModel()
    }

    private fun initUI() {
        binding.list.layoutManager = GridLayoutManager(activity, 2)
        binding.list.adapter = photoListAdapter
    }

    private fun initViewModel() {
        viewModel.dataState.observe(viewLifecycleOwner, Observer { dataState ->
            render(dataState)
        })

        viewModel.setStateEvent(FetchPhotosList)
    }

    private fun render(dataState: DataState<List<Photo>>?) {
        when(dataState){
            is DataState.Success<List<Photo>> -> {
                displayProgressBar(false)
                photoListAdapter.photos.clear()
                photoListAdapter.photos.addAll(dataState.data)
                photoListAdapter.notifyDataSetChanged()
            }
            is DataState.Error -> {
                displayProgressBar(false)
                displayError(dataState.exception.message)
            }
            is DataState.Loading -> {
                displayProgressBar(true)
            }
        }
    }

    private fun displayError(message: String?){
        binding.text.visibility = View.VISIBLE

        if(message != null) {
            binding.text.text = message
        } else {
           binding.text.text = "Unknown error."
        }
    }

    private fun displayProgressBar(isDisplayed: Boolean){
        binding.progressBar.visibility = if(isDisplayed) View.VISIBLE else View.GONE
    }
}