package yahl

package object utils:

  trait Show[A]:
    def show(a: A): String

  object Show:
    given stringShow: Show[String] = new Show[String]:
      def show(a: String) = a
    extension [A](a: A)
      def show(using instance: Show[A]): String = instance show a
