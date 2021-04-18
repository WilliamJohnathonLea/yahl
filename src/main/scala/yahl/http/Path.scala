package yahl.http

import yahl.utils.Show

final case class Path(segments: List[String]):
  def / (other: String): Path = Path(segments :+ other)
  def / (other: Path): Path = Path(segments ++ other.segments)

object Path:
  given showPath: Show[Path] = new Show[Path]:
    override def show(a: Path) = a.segments.mkString("/")

  val Root: Path = Path("/" :: Nil)
