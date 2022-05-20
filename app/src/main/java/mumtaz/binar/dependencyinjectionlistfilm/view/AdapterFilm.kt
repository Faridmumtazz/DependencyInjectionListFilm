package mumtaz.binar.dependencyinjectionlistfilm.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_film.view.*
import mumtaz.binar.dependencyinjectionlistfilm.R
import mumtaz.binar.dependencyinjectionlistfilm.model.GetAllFilmResponseItem

class AdapterFilm ( private var onclick : (GetAllFilmResponseItem)->Unit): RecyclerView.Adapter<AdapterFilm.ViewHolder>() {

    private var datafilm : List<GetAllFilmResponseItem>? = null
    fun setDataFilm(film : List<GetAllFilmResponseItem>){
        this.datafilm = film
    }
    class ViewHolder(itemView : View): RecyclerView.ViewHolder(itemView) {

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterFilm.ViewHolder {
        val itemview = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_film, parent, false)
        return  ViewHolder(itemview)
    }

    override fun onBindViewHolder(holder: AdapterFilm.ViewHolder, position: Int) {
        Glide.with(holder.itemView.context).load(datafilm!![position].image).into(holder.itemView.img_filmm)

        holder.itemView.tv_judulfilm.text = datafilm!![position].name
        holder.itemView.tv_tglfilm.text = datafilm!![position].date
        holder.itemView.tv_sutradarafilm.text = datafilm!![position].director



        holder.itemView.card_film.setOnClickListener {
            onclick(datafilm!![position])
        }

    }

    override fun getItemCount(): Int {
        if (datafilm == null) {
            return 0
        } else {
            return datafilm!!.size
        }
    }

}