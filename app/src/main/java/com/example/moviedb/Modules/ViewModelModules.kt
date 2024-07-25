package com.example.moviedb.Modules

import com.example.moviedb.Feature.Home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val ViewModelModule = module {
    viewModel{HomeViewModel()}
}
