package com.usine

/**
 * Représentation d'une usine de production de trombones dans le jeu. Une usine permet de produire des "batch" trombones
 * d'une certaine [qualite]. Chaque "batch" prend un certain [tempsProduction] a produire et permet d'obtenir un nombre
 * de trombones de [quantiteProduite]. L'usine possède également des fonds de pruduction sous forme d'[argent].
 */
class Usine(
    var qualite: QualiteProduction,
    var quantiteProduite : Int,
    var tempsProduction : Float,
    var argent : Int){

    /**
     * Applique une amélioration sur l'usine
     */
    fun appliquer(amelioration : Amelioration) {
        amelioration.appliquer(this)
    }

    /**
     * Si possible achète un élément qui coute [cout] argent. Retourne true si l'achat est possible, false autrement.
     */
    fun acheteSiPossible(cout : Int) : Boolean {
        if (cout <= argent) {
            argent -= cout
            return true
        }

        return false
    }

    override fun toString(): String {
        return "Usine (qualite : $qualite, quantite : $quantiteProduite, temps : %.2f, argent : $argent)".format(tempsProduction)
    }
}