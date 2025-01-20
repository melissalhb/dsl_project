// DSL pour gérer les configurations en Scala
final case class ConfigKey[A](name: String)

final case class ConfigValue[A](value: A)

final case class Config private (entries: Map[ConfigKey[_], ConfigValue[_]]) {
  def add[A](key: ConfigKey[A], value: A): Config = {
    Config(entries + (key -> ConfigValue(value)))
  }

  def get[A](key: ConfigKey[A]): Option[A] = {
    entries.get(key).flatMap {
      case ConfigValue(value: A) => Some(value)
      case _ => None
    }
  }
}

object Config {
  def empty: Config = Config(Map.empty)
}

// DSL pour construire des configurations
object ConfigDSL {
  def define[A](name: String): ConfigKey[A] = ConfigKey[A](name)

  def config(init: Config => Config): Config = {
    init(Config.empty)
  }
}

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
  }

  // Appeler run() explicitement
  run()
}
