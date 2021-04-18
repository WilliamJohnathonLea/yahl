# YAHL (Yet Another HTTP Library)

This is an academic exercise to build an HTTP DSL using Scala 3.

## Features
- DSL for creating HTTP routes.
- Synchronous Request/Reponse handling (for now)
- Request filtering
- more coming...

## Build a `Path`
```scala
import yahl.http.Path
import yahl.http.syntax._

val myPath: Path = "hello" / "world"
```

## Build a `Route`
```scala
import yahl.http._
import yahl.http.syntax._
import yahl.http.server._
import yahl.http.server.syntax._

val myHandler = (req: Request) =>
  new Response:
    override val code: Int = 200
    override val body: String = s"hello, you sent: ${req.body}"

val myRoute: Route =
  ("hello" / "world") handledBy myHandler
```

## Build a `Router`
```scala
import yahl.http._
import yahl.http.syntax._
import yahl.http.server._
import yahl.http.server.syntax._

val myHandler = (req: Request) =>
  new Response:
    override val code: Int = 200
    override val body: String = s"hello, you sent: ${req.body}"

val myRoute: Route =
  ("hello" / "world") handledBy myHandler

val myOtherRoute: Route =
  ("hello" / "again" / "world") handledBy myHandler

// With just one route...
val myRouterA: Router = new Router(myRoute :: Nil)

// With multiple routes...
val myRouterB: Router = myRoute ~ myOtherRoute
```
