// DSL pour gérer les configurations
final case class ConfigKey[A](name: String)

final case class ConfigValue[A](value: A)

final case class Config private (entries: Map[ConfigKey[_], ConfigValue[_]]) {
  def add[A](key: ConfigKey[A], value: A): Config = {
    Config(entries + (key -> ConfigValue(value)))
  }

  def get[A](key: ConfigKey[A]): Option[A] = {
    entries.get(key) match {
      case Some(ConfigValue(value: A @unchecked)) => Some(value)
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