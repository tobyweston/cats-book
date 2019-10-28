package bad.robot.cats._1_typeclasses

final case class Cat(name: String, age: Int, colour: String)

object Cat {
  import PrintableInstances._

  implicit val printable: Printable[Cat] = new Printable[Cat] {
    def format(cat: Cat): String = {
      val name = Printable.format(cat.name)
      val age = Printable.format(cat.age)
      val colour = Printable.format(cat.colour)
      s"$name is a $age year-old $colour cat"
    }
  }
}

object Application extends App {

  val cat = Cat("Garfield", 5, "Orange and black")

  Printable.print(cat)

  import PrintableSyntax._

  cat.print
}
