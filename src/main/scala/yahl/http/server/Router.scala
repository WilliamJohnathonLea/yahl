package yahl.http.server

import yahl.http.Path
import yahl.http.Request
import yahl.http.Response
import yahl.utils.Show.show

class Router(routes: List[Route]):

  /**
   * The route map is computed lazily so that it is only
   * built when the router is actually used for requests.
   */
  private lazy val routeMap: Map[Path, Route] =
    routes.map(route => route.path -> route).toMap

  private def unhandledResponse(path: Path): Response =
    new Response:
      override val code = 501
      override val body = s"The route with path ${path.show} has no handler"

  def ~ (route: Route): Router = new Router(route :: routes)

  def apply(req: Request): Response =
    routeMap(req.uri.path) match
      case Route.Unhandled(p) => unhandledResponse(p)
      case Route.Handled(_, handler) => handler(req)

end Router
