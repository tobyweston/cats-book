package bad.robot.cats._1_typeclasses

final case class Cat(name: String, age: Int, colour: String)

object Cat {
  implicit val printable: Printable[Cat] = new Printable[Cat] {
    def format(cat: Cat): String = s"${cat.name} is a ${cat.age} year-old ${cat.colour} cat"
  }
}

object Application extends App {
  
  val cat = Cat("Garfield", 5, "Orange and black")

  Printable.print(cat)
  
  import PrintableSyntax._
  
  cat.print
}

