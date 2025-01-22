error id: file:///C:/Users/mella/dsl_project/dsl_project/src/main/scala/scala.worksheet.sc:[79..86) in Input.VirtualFile("file:///C:/Users/mella/dsl_project/dsl_project/src/main/scala/scala.worksheet.sc", "// worksheet1.scala

import my.actual.package.ConfigDSL._
package my.actual.package
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
file:///C:/Users/mella/dsl_project/dsl_project/src/main/scala/scala.worksheet.sc:4: error: expected identifier; obtained package
package my.actual.package
                  ^
#### Short summary: 

expected identifier; obtained package