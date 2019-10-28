package bad.robot.cats._1_typeclasses

// the type class
trait Printable[A] {
  def format(value: A): String
}

// type class "interfaces" (as in contracts)
// two typical ways to do this. 1) interface object (as in this one)
object Printable {
  def format[A](a: A)(implicit printable: Printable[A]): String = printable.format(a)
  def print[A](a: A)(implicit evidence: Printable[A]): Unit = println(format(a))
}

// and 2) interface syntax (implicit classes to extend a type)
object PrintableSyntax {
  implicit class PrintableOps[A](a: A) {
    def format(implicit printable: Printable[A]): String = printable.format(a)
    def print(implicit printable: Printable[A]): Unit = println(format(printable))
  }
}

// type class instances
object PrintableInstances {
  implicit val printableString: Printable[String] = new Printable[String] {
    override def format(value: String): String = value
  }

  implicit val printableInt: Printable[Int] = new Printable[Int] {
    override def format(value: Int): String = value.toString
  }
}
