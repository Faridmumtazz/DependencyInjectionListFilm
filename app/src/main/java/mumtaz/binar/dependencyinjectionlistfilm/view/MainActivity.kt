package mumtaz.binar.dependencyinjectionlistfilm.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import mumtaz.binar.dependencyinjectionlistfilm.R
import mumtaz.binar.dependencyinjectionlistfilm.viewmodel.ViewModelFilm

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getDataFilm()
    }

    fun getDataFilm(){
        val filmAdapter = AdapterFilm(){
            val pindah = Intent(this, DetailFilmActivity::class.java)
            pindah.putExtra("detailfilm", it)
            startActivity(pindah)
        }

        rv_film.layoutManager = LinearLayoutManager(this)
        rv_film.adapter = filmAdapter

        val viewModel = ViewModelProvider(this).get(ViewModelFilm::class.java)

        viewModel.film.observe(this){
            if (it != null){
                filmAdapter.setDataFilm(it)
                filmAdapter.notifyDataSetChanged()
            }
        }

    }
}