package yahl.http

import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers

import yahl.http.Path
import yahl.http.syntax._

class PathTest extends AnyWordSpec with Matchers {

  "The slash (/) operator" when {

    "used with two strings" should {
      "produce a Path" in {
        val expected = Path("hello" :: "world" :: Nil)
        ("hello" / "world") shouldEqual expected
      }
    }

    "used with a Path and a string" should {
      "produce a Path" in {
        val path = Path("hello" :: Nil)
        val expected = Path("hello" :: "world" :: Nil)
        (path / "world") shouldEqual expected
      }
    }

    "used with a two Paths" should {
      "produce a Path" in {
        val path = Path("hello" :: Nil)
        val other = Path("world" :: Nil)
        val expected = Path("hello" :: "world" :: Nil)
        (path / other) shouldEqual expected
      }
    }

  }
}
