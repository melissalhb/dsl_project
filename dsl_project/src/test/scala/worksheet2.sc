import ConfigDSL._

val hostKey = define[String]("host")
val portKey = define[Int]("port")

val config = config { cfg =>
  cfg
    .add(hostKey, "localhost")
    .add(portKey, 8080)
}

val updatedConfig = config.update(portKey, _ + 1)

println(updatedConfig.get(portKey))  // Expected: Some(8081)