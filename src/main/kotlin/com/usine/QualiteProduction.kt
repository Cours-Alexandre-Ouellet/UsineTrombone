package com.usine

/**
 * Différentes qualités de production disponibles dans l'usine.
 */
enum class QualiteProduction {

    Faible {
        override fun qualiteSuivante(): QualiteProduction {
            return Moyenne
        }
    },
    Moyenne {
        override fun qualiteSuivante(): QualiteProduction {
            return Elevee
        }
    },
    Elevee {
        override fun qualiteSuivante(): QualiteProduction? {
            return null
        }
    };

    /**
     * Retourne la qualité de production d'un niveau supérieure à celle actuelle.
     */
    abstract fun qualiteSuivante(): QualiteProduction?

}