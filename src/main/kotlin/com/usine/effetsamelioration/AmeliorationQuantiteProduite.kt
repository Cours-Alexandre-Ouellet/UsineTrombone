package com.usine.effetsamelioration

import com.usine.Usine
import kotlinx.serialization.Serializable

/**
 * Augmente la quantite de trombone produit à chaque "batch"
 */
@Serializable
class AmeliorationQuantiteProduite(val quantiteAugmentee : Int) : EffetAmelioration {

    override fun appliquer(usine: Usine) {
        usine.quantiteProduite += quantiteAugmentee
    }

    override fun toString(): String {
        return "Produit $quantiteAugmentee trombones de plus"
    }
}