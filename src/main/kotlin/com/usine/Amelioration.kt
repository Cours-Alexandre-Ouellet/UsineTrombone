package com.usine

import com.usine.effetsamelioration.EffetAmelioration
import kotlinx.serialization.Serializable

/**
 * Représente une amélioration qui peut être achetée pour augmenter la capacité de l'usine. Chaque amélioration est
 * identifiée par un [nom], possède un [cout] d'achat et prend un temps [tempsRecherche] a acquérir. Chaque amélioration
 * peut avoir un ou plusieurs [effetsAmelioration].
 */
@Serializable
class Amelioration(
    val nom: String,
    val cout: Int,
    val tempsRecherche: Long,
    val effetsAmelioration: Array<EffetAmelioration>
) {

    /**
     * Applicque l'amélioration à une [usine] précisée
     */
    fun appliquer(usine: Usine) {
        TempsUtil.attendre(tempsRecherche)
        effetsAmelioration.forEach { effetAmelioration -> effetAmelioration.appliquer(usine) }
    }

    override fun toString(): String {
        return "$nom (coût : $cout, temps : $tempsRecherche)\n${
            effetsAmelioration.joinToString(separator = "\n") { effet -> "\t$effet" }
        }"
    }
}