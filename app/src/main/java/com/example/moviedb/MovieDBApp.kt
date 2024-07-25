package com.example.moviedb

import android.app.Application
import android.content.Context
import com.example.moviedb.Api.configuration.ConfigurationService
import com.example.moviedb.Api.configuration.IApplicationConfiguration
import com.example.moviedb.Modules.ApiModules
import com.example.moviedb.Modules.AppModule
import com.example.moviedb.Modules.ServiceModules
import com.example.moviedb.Modules.ViewModelModule
import org.koin.android.ext.android.inject
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin


class MovieDBApp: Application() {

    private val applicationConfiguration by inject<IApplicationConfiguration>()
    private val configurationService by inject<ConfigurationService>()
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@MovieDBApp)
            modules(
                ViewModelModule,
                AppModule,
                ApiModules,
                ServiceModules)
        }

        configurationService.addOrChangeConfiguration(applicationConfiguration)
    }
}