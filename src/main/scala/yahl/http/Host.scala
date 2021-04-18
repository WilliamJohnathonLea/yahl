package yahl.http

import yahl.utils.Show

final case class Host(domain: String, port: Int)

object Host:
  given showHost: Show[Host] = new Show[Host]:
    override def show(a: Host) =
      s"${a.domain}:${a.port}"
