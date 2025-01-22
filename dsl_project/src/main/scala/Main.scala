// Exemple d'utilisation du DSL
object Main extends App {
  import ConfigDSL._

  def run(): Unit = {
    // Définir des clés typées
    val hostKey = define[String]("host")
    val portKey = define[Int]("port")

    // Créer une configuration avec une syntaxe fluide
    val appConfig = config { config =>
      config
        .add(hostKey, "localhost")
        .add(portKey, 8080)
    }

    // Lire les valeurs
    println(appConfig.get(hostKey)) // Some("localhost")
    println(appConfig.get(portKey)) // Some(8080)

    // Mettre à jour une valeur
    val updatedConfig = appConfig.add(portKey, 8081)
    println(updatedConfig.get(portKey)) // Some(8081)

    // Tester une clé non existante
    val nonExistentKey = define[Int]("nonExistent")
    println(appConfig.get(nonExistentKey)) // None
  }

  // Appeler run explicitement
  run()
}