package mumtaz.binar.dependencyinjectionlistfilm.di

import mumtaz.binar.dependencyinjectionlistfilm.model.GetAllFilmResponseItem
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("film")
    suspend fun getAllFilm() : List<GetAllFilmResponseItem>
}