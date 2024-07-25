package com.example.moviedb.Api.configuration

import org.koin.core.component.KoinComponent
import org.koin.core.qualifier.named
import org.koin.core.scope.Scope

class ConfigurationService : KoinComponent {
    lateinit var scope : Scope

    init {
        createScope()
    }

    private fun createScope() {
        scope =
            getKoin().createScope("${named<ConfigurationService>()}", named<ConfigurationService>())
    }

    private fun closeScope() {
        scope.close()
    }

    fun addOrChangeConfiguration(newApplicationConfiguration: IApplicationConfiguration) {
        closeScope()
        createScope()
        scope.declare(newApplicationConfiguration)
    }
}