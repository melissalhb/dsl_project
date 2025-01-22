import ConfigDSL._

val hostKey = define[String]("host")
val nonExistentKey = define[Int]("nonExistent")

val config = config { cfg =>
  cfg.add(hostKey, "localhost")
}

println(config.get(nonExistentKey))  // Expected: None