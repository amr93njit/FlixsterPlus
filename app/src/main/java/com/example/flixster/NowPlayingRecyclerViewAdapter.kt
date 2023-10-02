package com.example.flixster

import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.module.AppGlideModule
import android.content.Intent
import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.flixster.R.id

class NowPlayingRecyclerViewAdapter(
    private val movies: List<NowPlaying>,
    private val mListener: OnListFragmentInteractionListener?
)
    : RecyclerView.Adapter<NowPlayingRecyclerViewAdapter.MovieViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_now_playing, parent, false)
        return MovieViewHolder(view)
    }

    inner class MovieViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
        var mItem: NowPlaying? = null
        val mMovieTitle: TextView = mView.findViewById<View>(R.id.movie_title) as TextView
        val mMovieDescription: TextView = mView.findViewById<View>(R.id.movie_description) as TextView
        val mMovieImage: ImageView = mView.findViewById<View>(R.id.movie_image) as ImageView
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = movies[position]
        holder.mMovieTitle.text = movie.title
        holder.mMovieDescription.text = movie.description
        Glide.with(holder.mView)
            .load("https://image.tmdb.org/t/p/w500/${movie.movieImageUrl}")//normal
            .placeholder(R.drawable.ic_launcher_foreground)//placeholder
            .error(R.drawable.ic_launcher_background)//error
            .centerCrop()
            .into(holder.mMovieImage)

        //needed. forgot why but we need it
        holder.mView.setOnClickListener {
            holder.mItem?.let { movie ->
                mListener?.onItemClick(movie)
            }
        }
    }

    override fun getItemCount(): Int {
        return movies.size
    }
}