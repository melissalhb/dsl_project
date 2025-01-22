import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class ConfigSpec extends AnyFlatSpec with Matchers {

  "A Config" should "allow adding and retrieving string values" in {
    val hostKey = ConfigDSL.define[String]("host")
    val config = ConfigDSL.config { c =>
      c.add(hostKey, "localhost")
    }

    config.get(hostKey) should be(Some("localhost"))
  }

  it should "allow adding and retrieving integer values" in {
    val portKey = ConfigDSL.define[Int]("port")
    val config = ConfigDSL.config { c =>
      c.add(portKey, 8080)
    }

    config.get(portKey) should be(Some(8080))
  }

  it should "return None when a key does not exist" in {
    val hostKey = ConfigDSL.define[String]("host")
    val config = ConfigDSL.config { c =>
      c.add(hostKey, "localhost")
    }

    val nonExistentKey = ConfigDSL.define[Int]("nonExistent")
    config.get(nonExistentKey) should be(None)
  }

  "An empty config" should "return None for any key" in {
    val hostKey = ConfigDSL.define[String]("host")
    val config = Config.empty

    config.get(hostKey) should be(None)
  }

  it should "store and retrieve multiple key-value pairs" in {
    val hostKey = ConfigDSL.define[String]("host")
    val portKey = ConfigDSL.define[Int]("port")

    val config = ConfigDSL.config { c =>
      val updatedConfig = c.add(hostKey, "localhost")
      val finalConfig = updatedConfig.add(portKey, 8080)
      finalConfig
    }

    config.get(hostKey) should be(Some("localhost"))
    config.get(portKey) should be(Some(8080))
  }

}