package yahl.http

import yahl.utils.Show

enum Protocol:
  case HTTP, HTTPS

object Protocol:
  given showHttpProtocol: Show[Protocol] = new Show[Protocol]:
    override def show(a: Protocol) =
      a match
        case HTTP => "http"
        case HTTPS => "https"
