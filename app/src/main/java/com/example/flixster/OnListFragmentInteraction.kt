package com.example.flixster

/**
 * This interface is used by the [NowPlayingRecyclerViewAdapter] to ensure
 * it has an appropriate Listener.
 *
 * In this app, it's implemented by [NowPlayingFragment]
 */
interface OnListFragmentInteractionListener {
    fun onItemClick(item: NowPlaying)
}
