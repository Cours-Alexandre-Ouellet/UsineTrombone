package com.usine

import java.util.concurrent.TimeUnit

/**
 * Utilitaire pour gérer les temps d'attente
 */
object TempsUtil {

    /**
     * Attend une certaine durée
     */
    fun attendre(temps : Long) {
        TimeUnit.MILLISECONDS.sleep(temps)
    }

}