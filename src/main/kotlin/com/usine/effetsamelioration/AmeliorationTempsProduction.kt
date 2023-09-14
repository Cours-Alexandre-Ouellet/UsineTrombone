package com.usine.effetsamelioration

import com.usine.Usine
import kotlinx.serialization.Serializable

/**
 * Réduit le temps nécessaire à produire une "batch" de trombones
 */
@Serializable
class AmeliorationTempsProduction(val facteurTempsProduction : Float) : EffetAmelioration {

    override fun appliquer(usine: Usine) {
        usine.tempsProduction *= (1.0f - facteurTempsProduction);
    }

    override fun toString(): String {
        return "Accéléré par %.2f".format(facteurTempsProduction)
    }
}