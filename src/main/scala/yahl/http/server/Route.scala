package yahl.http.server

import yahl.http.Path
import yahl.http.Request
import yahl.http.Response

sealed trait Route:
  def path: Path

object Route:

  final case class Unhandled(path: Path)
    extends Route

  final case class Handled(
    path: Path,
    filter: Request => Either[Response, Request],
    handler: Request => Response
  ) extends Route
