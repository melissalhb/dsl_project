import ConfigDSL._

object Worksheet4 extends App {
  val hostKey = define[String]("host")
  val portKey = define[Int]("port")
  val maxThreadsKey = define[Int]("maxThreads")
  val enableSSLKey = define[Boolean]("enableSSL")

  val webServerConfig = config { cfg =>
    cfg
      .add(hostKey, "localhost")
      .add(portKey, 8080)
      .add(maxThreadsKey, 100)
      .add(enableSSLKey, true)
  }

  // Print web server configuration values
  println(webServerConfig.get(hostKey))       // Expected: Some("localhost")
  println(webServerConfig.get(portKey))       // Expected: Some(8080)
  println(webServerConfig.get(maxThreadsKey)) // Expected: Some(100)
  println(webServerConfig.get(enableSSLKey))  // Expected: Some(true)
}