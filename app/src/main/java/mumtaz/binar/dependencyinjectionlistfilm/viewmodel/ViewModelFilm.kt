package mumtaz.binar.dependencyinjectionlistfilm.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import mumtaz.binar.dependencyinjectionlistfilm.di.ApiService
import mumtaz.binar.dependencyinjectionlistfilm.model.GetAllFilmResponseItem
import javax.inject.Inject

@HiltViewModel
class ViewModelFilm @Inject constructor(api : ApiService): ViewModel(){

    private var liveDataFilm = MutableLiveData<List<GetAllFilmResponseItem>>()

    val film : LiveData<List<GetAllFilmResponseItem>> = liveDataFilm

    init {
        viewModelScope.launch {
            val datafilm = api.getAllFilm()
            delay(2000)
            liveDataFilm.value = datafilm
        }
    }




}