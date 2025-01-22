import ConfigDSL._

val hostKey = define[String]("host")
val portKey = define[Int]("port")

val config = config { cfg =>
  cfg
    .add(hostKey, "localhost")
    .add(portKey, 8080)
}

println(config.get(hostKey))  
println(config.get(portKey))  

val updatedConfig = config.update(portKey, _ + 1)
println(updatedConfig.get(portKey)) 