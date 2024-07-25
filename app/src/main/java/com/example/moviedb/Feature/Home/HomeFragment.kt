package com.example.moviedb.Feature.Home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.moviedb.Model.Movie
import com.example.moviedb.databinding.FragmentHomeBinding
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel


/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {

    private lateinit var binding : FragmentHomeBinding

    private val viewModel by viewModel<HomeViewModel>()

    private lateinit var recyclerView : RecyclerView
    private lateinit var adapter : MovieAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        recyclerView = binding.moviesRecyclerview

        recyclerView.layoutManager = LinearLayoutManager(activity)
        adapter = MovieAdapter(emptyArray())
        recyclerView.adapter = adapter

//        viewLifecycleOwner.lifecycleScope.launch {
//            viewModel.search()
//        }

        val movieArrayObserver = Observer<Array<Movie>>{
            adapter.updateDataSet(it)
        }

        viewModel.moviesArray.observe(viewLifecycleOwner, movieArrayObserver)

        viewModel.search("a")
        return binding.root
    }
}