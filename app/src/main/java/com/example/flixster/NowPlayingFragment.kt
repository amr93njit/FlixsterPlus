package com.example.flixster

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.ContentLoadingProgressBar
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.codepath.asynchttpclient.AsyncHttpClient
import com.codepath.asynchttpclient.RequestParams
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler
import com.example.flixster.NowPlayingRecyclerViewAdapter
import com.example.flixster.OnListFragmentInteractionListener
import com.example.flixster.R
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import okhttp3.Headers
import org.json.JSONArray
import org.json.JSONObject

private const val API_KEY = "a07e22bc18f5cb106bfe4cc1f83ad8ed"
class NowPlayingFragment : Fragment(), OnListFragmentInteractionListener {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_now_playing_list, container, false)
        val progressBar = view.findViewById<View>(R.id.progress) as ContentLoadingProgressBar
        val recyclerView = view.findViewById<View>(R.id.list) as RecyclerView
        val context = view.context
        recyclerView.layoutManager = GridLayoutManager(context, 1)
        updateAdapter(progressBar, recyclerView)
        return view
    }

    private fun updateAdapter(progressBar: ContentLoadingProgressBar, recyclerView: RecyclerView) {
        progressBar.show()

        val client = AsyncHttpClient()
        val params = RequestParams()
        params["api-key"] = API_KEY

        client[
            "https://api.themoviedb.org/3/movie/now_playing?api_key=$API_KEY",
            params,
            object : JsonHttpResponseHandler()
            {
                override fun onSuccess(
                    statusCode: Int,
                    headers: Headers,
                    json: JSON
                ) {
                    progressBar.hide()
                    //figuring out serialized names in JSON
                    Log.d("JSONResponse", json.toString())

                    val arrayMovieType = object : TypeToken<List<NowPlaying>>() {}.type
                    val resultsArray = json.jsonObject.getJSONArray("results")
                    val gson = Gson()
                    val models: List<NowPlaying> = gson.fromJson(resultsArray.toString(), arrayMovieType)
                    recyclerView.adapter = NowPlayingRecyclerViewAdapter(models, this@NowPlayingFragment)

                    Log.d("NowPlayingFragment", "response successful")
                }
                override fun onFailure(
                    statusCode: Int,
                    headers: Headers?,
                    errorResponse: String,
                    t: Throwable?
                ) {
                    progressBar.hide()
                    t?.message?.let {
                        Log.e("NowPlayingFragment", errorResponse)
                    }
                }
            }]

    }

    override fun onItemClick(item: NowPlaying) {
        TODO("Not yet implemented")
    }
}
