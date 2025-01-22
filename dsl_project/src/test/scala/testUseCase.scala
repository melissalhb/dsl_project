import org.scalatest.funsuite.AnyFunSuite
import ConfigDSL._

class ConfigDSLTests extends AnyFunSuite {

  test("Adding and retrieving a single configuration") {
    val hostKey = define[String]("host")
    val appConfig = config(_.add(hostKey, "localhost"))

    assert(appConfig.get(hostKey).contains("localhost"))
  }

  test("Adding multiple configurations and retrieving them") {
    val hostKey = define[String]("host")
    val portKey = define[Int]("port")
    val appConfig = config { cfg =>
      cfg.add(hostKey, "localhost").add(portKey, 8080)
    }

    assert(appConfig.get(hostKey).contains("localhost"))
    assert(appConfig.get(portKey).contains(8080))
  }

  test("Retrieving a non-existent key returns None") {
    val hostKey = define[String]("host")
    val appConfig = config(_.add(hostKey, "localhost"))

    val nonExistentKey = define[Int]("nonExistent")
    assert(appConfig.get(nonExistentKey).isEmpty)
  }
}