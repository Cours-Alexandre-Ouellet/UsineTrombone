package com.usine

import kotlin.math.ceil

/**
 * Gère le fonctionnement du "jeu" de l'usine à trombone
 */
class Application {

    /**
     * Liste des améliorations qui peuvent être achetée par le joueur
     */
    private val ameliorationsDisponibles: MutableList<Amelioration> = EnregistreurDonnees.charger().toMutableList()

    /**
     * L'usine gérée par le joueur
     */
    private val usine = Usine(QualiteProduction.Faible, 1, 10.0f, 50)

    /**
     * Affiche le menu principal du jeu
     */
    private fun afficherMenu() {
        println("Menu du système d'usine")
        println("Saisissez le nombre correspondant à l'option choisie")
        println("1) Afficher l'usine")
        println("2) Acheter une amélioration")
        println("3) Produire une batch de trombones")
        println("0) Quitter")
    }

    /**
     * Boucle de jeu et gestion des options du menu principal
     */
    fun executerSysteme() {
        var quitter: Boolean = false

        while (!quitter) {
            afficherMenu()

            // when -> switch
            when (saisirOption()) {
                0 -> quitter = true
                1 -> println(usine)
                2 -> acheterAmelioration()
                3 -> produireBatch()
                else -> println("Veuillez entrer une valeur valide.")
            }
        }
    }

    /**
     * Permet de lire une entrée entière au clavier. Si l'entrée est invalide, alors la valeur nulle est retournée
     */
    private fun saisirOption(): Int? {
        val contenu = readln()
        return try {
            contenu.toInt()
        } catch (ex: NumberFormatException) {
            null
        }
    }

    /**
     * Réalise l'achat d'une amélioration
     */
    private fun acheterAmelioration() {
        val amelioration = choisirAmelioration()

        // Choix valide d'amélioration
        if (amelioration != null) {

            // Le joueur possède les fonds
            if (usine.acheteSiPossible(amelioration.cout)) {
                println("Amélioration en recherche (${amelioration.tempsRecherche} secondes)")
                TempsUtil.attendre(amelioration.tempsRecherche * 1000)  // Conversion en millisecondes
                usine.appliquer(amelioration)
                println("Amelioration completée")
            } else {
                println("Fonds insuffisant pour acheter l'amélioration")
            }
        }
    }

    /**
     * Affiche les améliorations disponibles et permet d'en sélectionner une. L'amélioration sélectionnée est retournée.
     */
    private fun choisirAmelioration(): Amelioration? {
        var choixValide = false
        var ameliorationSelectionnee: Amelioration? = null

        while (!choixValide) {

            // Affichage des options
            println("Quelle amélioration voulez-vous acheter ?")
            ameliorationsDisponibles.forEachIndexed { index, amelioration ->
                println("${index + 1}) $amelioration")
            }
            println("0) Revenir au menu")

            val optionChoisie = saisirOption()

            if (optionChoisie != null && optionChoisie >= 0 && optionChoisie <= ameliorationsDisponibles.size) {
                choixValide = true

                if (optionChoisie > 0) {
                    ameliorationSelectionnee = ameliorationsDisponibles[optionChoisie - 1]
                    ameliorationsDisponibles.remove(ameliorationSelectionnee)
                }
            } else {
                println("Veuillez indiquer une option valide.")
            }
        }

        return ameliorationSelectionnee
    }

    /**
     * Produit une batch de trombones dans l'usine.
     */
    private fun produireBatch() {
        val tempsProduction : Long = ceil(usine.tempsProduction * 1000).toLong()

        println("Début de la production (%.2f secondes)".format(tempsProduction / 1000.0))
        TempsUtil.attendre(tempsProduction)
        println("Production de ${usine.quantiteProduite} trombone${if (usine.quantiteProduite > 1) "s" else ""}" +
                " de qualite \"${usine.qualite.name}\"")
    }

}

/**
 * Fonction principale du programme
 */
fun main() {
    val application = Application()
    application.executerSysteme()
}
