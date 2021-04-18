package yahl

import yahl.utils.Show
import yahl.utils.Show.show

package object http:

  object syntax:
    extension (string: String)
      def / (other: String): Path = Path(string :: other :: Nil)
      def asPath: Path = Path(string :: Nil)

  trait Request:
    def uri: Uri
    def body: String // change

  trait Response:
    def code: Int
    def body: String // change

end http

