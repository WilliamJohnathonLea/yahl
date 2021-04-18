package yahl.http

import yahl.utils.Show
import yahl.utils.Show.show

final case class Uri(
  protocol: Protocol,
  host: Host,
  path: Path
)

object Uri:
  given showUri: Show[Uri] = new Show[Uri]:
    override def show(a: Uri) =
      s"${a.protocol.show}://${a.host.show}/${a.path.show}"
