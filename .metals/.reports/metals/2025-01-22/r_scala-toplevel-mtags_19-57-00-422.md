error id: file:///C:/Users/mella/dsl_project/dsl_project/src/main/scala/scala.worksheet.sc:[39..46) in Input.VirtualFile("file:///C:/Users/mella/dsl_project/dsl_project/src/main/scala/scala.worksheet.sc", "// worksheet1.scala
package my.actual.package
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
")
file:///C:/Users/mella/dsl_project/dsl_project/src/main/scala/scala.worksheet.sc:2: error: expected identifier; obtained package
package my.actual.package
                  ^
#### Short summary: 

expected identifier; obtained package