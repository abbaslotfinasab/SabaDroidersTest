package com.example.challenge

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.models.ItemModel
import com.example.domain.utile.Result
import com.example.domain.usecases.MovieListUseCaseImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(

    private val movieListUseCaseImpl: MovieListUseCaseImpl

) : ViewModel() {

    private val _mainModel = MutableLiveData<Result<MutableList<ItemModel>>>()
    val mainModel: LiveData<Result<MutableList<ItemModel>>>
        get() = _mainModel

    private val handler = CoroutineExceptionHandler {
            _, exception ->
        _mainModel.postValue(exception.message?.let { Result.Error(it) })
    }

    fun getMovieList(query:String?=""){

        viewModelScope.launch(Dispatchers.IO+handler) {

            _mainModel.postValue(Result.Loading)

            movieListUseCaseImpl.execute(query).let {

                _mainModel.postValue(Result.Success(it))

            }
        }
    }
}