package com.example.moviedb.Feature.Home

import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.moviedb.Model.Movie
import com.example.moviedb.R
import java.time.format.DateTimeFormatter

class MovieAdapter(private var dataSet: Array<Movie>) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {
    class MovieViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val titleTextView : TextView
        val dateTextView : TextView
        val poster : ImageView
        val allView : View

        init {
            titleTextView = view.findViewById(R.id.movie_title)
            dateTextView = view.findViewById(R.id.release_date)
            poster = view.findViewById(R.id.imageView)
            allView = view
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.movie_viewholder,parent,false)

        return MovieViewHolder(view)
    }
    override fun onBindViewHolder(viewHolder: MovieViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.titleTextView.text = dataSet[position].originalTitle
        var dateString = if(dataSet[position].releaseDate != null)
            dataSet[position].releaseDate?.format(DateTimeFormatter.ofPattern("MMMM-dd-yyyy")).toString()
        else
            "No release date"
        viewHolder.dateTextView.text = dateString
        Glide.with(viewHolder.allView)
            .load(dataSet[position].posterUri)
            .into(viewHolder.poster)
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size

    public fun updateDataSet(movies : Array<Movie>){
        dataSet = movies
        notifyDataSetChanged()
    }
}