package yahl.main

import yahl.http._
import yahl.http.syntax._
import yahl.http.server.syntax._
import yahl.http.Protocol.{given, _}
import yahl.utils.Show.{given, _}

object Main extends App:
  val examplePath: Path = "hello" / "world"
  val exampleUri: Uri = Uri(HTTPS, Host("localhost", 443), examplePath)
  val exampleHandler = (req: Request) =>
    new Response:
      override val code = 200
      override val body = s"hello, you sent: ${req.body}"

  val exampleHandledRoute = examplePath handledBy exampleHandler
  val exampleUnhandledRoute = (examplePath / "test").unhandled

  val exampleRequst: Request = new Request:
    override val uri = exampleUri
    override val body = "test body"

  val exampleUnhandledRequst: Request = new Request:
    override val uri = exampleUri.copy(path = examplePath / "test")
    override val body = "test body"

  val router =
    Path.Root ~
      exampleHandledRoute ~
      exampleUnhandledRoute

  println(examplePath.show)
  println(exampleUri.show)
  println(router(exampleRequst).body)
  println(router(exampleUnhandledRequst).body)

end Main
