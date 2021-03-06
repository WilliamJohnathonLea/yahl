package yahl.http.server

import yahl.http.Path
import yahl.http.Request
import yahl.http.Response

package object syntax:

  extension (route: Route)
    def ~ (other: Route): Router =
      new Router(route :: other :: Nil)

  extension (route: Route)
    def usingFilter(
      filter: Request => Either[Response, Request]
    ): Route =
      route match
        case u @ Route.Unhandled(_) => u // nothing to do here...
        case h @ Route.Handled(path, _, handler) =>
          h.copy(path, filter, handler)

  extension (path: Path)
    def ~ (other: Route): Router =
      val route = Route.Unhandled(path)
      route ~ other

    def handledBy(handler: Request => Response): Route =
      Route.Handled(path, Right(_), handler)

    def unhandled: Route = Route.Unhandled(path)

end syntax
