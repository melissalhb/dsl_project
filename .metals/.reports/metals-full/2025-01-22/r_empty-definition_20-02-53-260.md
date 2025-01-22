error id: 
file:///C:/Users/mella/dsl_project/dsl_project/src/test/scala/worksheet1.scala
empty definition using pc, found symbol in pc: 
empty definition using semanticdb
|empty definition using fallback
non-local guesses:
	 -println.
	 -println#
	 -println().
	 -scala/Predef.println.
	 -scala/Predef.println#
	 -scala/Predef.println().

Document text:

```scala
// worksheet1.scala

// Importer le DSL de configuration
import ConfigDSL._
import ConfigDSL.{config => configDSL}

// Définir des clés de configuration
val hostKey = define[String]("host")
val portKey = define[Int]("port")

// Créer une configuration
val config = configDSL { cfg =>
  cfg
    .add(hostKey, "localhost")
    .add(portKey, 8080)
}

// Afficher les valeurs de configuration comme dans un worksheet
println(config.get(hostKey))  // Attendu : Some("localhost")
println(config.get(portKey))  // Attendu : Some(8080)
```

#### Short summary: 

empty definition using pc, found symbol in pc: 