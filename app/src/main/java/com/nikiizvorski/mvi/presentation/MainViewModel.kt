package com.nikiizvorski.mvi.presentation

import androidx.lifecycle.*
import com.nikiizvorski.mvi.entity.Photo
import com.nikiizvorski.mvi.util.DataState
import com.nikiizvorski.mvi.interactors.PhotoInteractorImpl
import com.nikiizvorski.mvi.presentation.StateEvent.FetchPhotosList
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@ExperimentalCoroutinesApi
@HiltViewModel
class MainViewModel
@Inject
constructor(
    private val photoInteractor: PhotoInteractorImpl,
    private val savedStateHandle: SavedStateHandle
): ViewModel() {

    private val _dataState: MutableLiveData<DataState<List<Photo>>> = MutableLiveData()

    val dataState: LiveData<DataState<List<Photo>>>
        get() = _dataState

    fun setStateEvent(stateEvent: StateEvent){
        viewModelScope.launch {
            when(stateEvent){
                is FetchPhotosList -> {
                    photoInteractor.execute()
                        .onEach {dataState ->
                            _dataState.value = dataState
                        }
                        .launchIn(viewModelScope)
                }
            }
        }
    }

}


sealed class StateEvent{

    object FetchPhotosList: StateEvent()

    object ZeroEvent: StateEvent()
}


















