package com.example.moviedb.Feature.Home

import android.content.res.Resources
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.moviedb.Model.Movie
import com.example.moviedb.R
import com.example.moviedb.databinding.FragmentHomeBinding
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel


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

        binding.textInputEditText.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun afterTextChanged(s: Editable?) {
                viewModel.query.value = s.toString()
            }
        })

        val queryObserver = Observer<String>{
            viewModel.search(it)
        }
        val movieArrayObserver = Observer<Array<Movie>>{
            adapter.updateDataSet(it)
        }

        viewModel.moviesArray.observe(viewLifecycleOwner, movieArrayObserver)
        viewModel.query.observe(viewLifecycleOwner, queryObserver)

        return binding.root
    }
}