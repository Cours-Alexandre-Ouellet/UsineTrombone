package com.usine.effetsamelioration

import com.usine.Usine
import kotlinx.serialization.Serializable

/**
 * Amélioration qui augmente d'un niveau la qualité de la production
 */
@Serializable
class AmeliorationQualiteProduction() : EffetAmelioration {

    override fun appliquer(usine: Usine) {
        // Utilisation du 'Elvis operator' pour s'assurer de ne pas assigner une valeur nulle
        usine.qualite = usine.qualite.qualiteSuivante() ?: usine.qualite
    }

    override fun toString(): String {
        return "+1 niveau de qualité"
    }
}