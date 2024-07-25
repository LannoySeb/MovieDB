package com.example.moviedb.Feature.Home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
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
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        recyclerView = binding.moviesRecyclerview

        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.adapter = MovieAdapter(viewModel.createMovieListStubs())

//        viewLifecycleOwner.lifecycleScope.launch {
//            viewModel.search()
//        }
        return binding.root
    }
}