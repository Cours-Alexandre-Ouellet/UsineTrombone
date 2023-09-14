package com.usine.effetsamelioration

import com.usine.Usine
import kotlinx.serialization.Serializable

/**
 * Effet pouvant être appliqué à une usine.
 */
@Serializable
sealed interface EffetAmelioration {

    /**
     * Applique l'effet à l'[usine] indiquée.
     */
    fun appliquer(usine: Usine)

}