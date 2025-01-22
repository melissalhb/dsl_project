error id: get.
file:///C:/Users/mella/dsl_project/dsl_project/src/main/scala/scala.worksheet.sc
empty definition using pc, found symbol in pc: get.
empty definition using semanticdb
|empty definition using fallback
non-local guesses:
	 -ConfigDSL.get.
	 -ConfigDSL.get#
	 -ConfigDSL.get().
	 -get.
	 -get#
	 -get().
	 -scala/Predef.get.
	 -scala/Predef.get#
	 -scala/Predef.get().

Document text:

```scala
// worksheet1.scala
import my.actual.package.ConfigDSL._

val hostKey = define[String]("host")
val portKey = define[Int]("port")

val config = config { config =>
  config
    .add(hostKey, "localhost")
    .add(portKey, 8080)
}

Predef.println(config.get(hostKey))  
Predef.println(config.get(portKey))

```

#### Short summary: 

empty definition using pc, found symbol in pc: get.