package com.usine

import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.encodeToStream
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths

/**
 * Gère la sérialization des données en json
 */
object EnregistreurDonnees {

    /**
     * Nom du fichier dans laquelle la sérialization a lieu
     */
    val nomFichier : Path = Paths.get("ameliorations.json")

    /**
     * Enregistre les [ameliorations] dans le fichier json
     */
    fun enregistrer(ameliorations: Array<Amelioration>) {
        val donnees = Json.encodeToString(ameliorations)

        Files.deleteIfExists(nomFichier)
        Files.writeString(nomFichier, donnees)
    }

    /**
     * Charge une liste d'améliorations du fichier json
     */
    fun charger() : Array<Amelioration> {
        val donnees = Files.readString(nomFichier)

        return Json.decodeFromString<Array<Amelioration>>(donnees)
    }

}