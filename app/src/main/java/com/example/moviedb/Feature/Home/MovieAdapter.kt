package com.example.moviedb.Feature.Home

import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.moviedb.Model.Movie
import com.example.moviedb.R

class MovieAdapter(private val dataSet: Array<Movie>) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {
    class MovieViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val titleTextView : TextView

        init {
            titleTextView = view.findViewById(R.id.movie_title)
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
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size

}