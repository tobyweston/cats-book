package bad.robot.cats._1_typeclasses

final case class Person(name: String, email: String)

sealed trait Json
final case class JsObject(get: Map[String, Json]) extends Json
final case class JsString(get: String) extends Json
final case class JsNumber(get: Double) extends Json
case object JsNull extends Json

// type class
trait JsonWriter[A] {
  def write(value: A): Json
}

// type class instance
object JsonWriterInstances {
  implicit val stringWriter: JsonWriter[String] = (value: String) => JsString(value)

  implicit val personWriter: JsonWriter[Person] = (value: Person) =>
    JsObject(
      Map(
        "name"  -> JsString(value.name),
        "email" -> JsString(value.email)
      )
  )
}

// (type class) interface object
object Json {
  def toJson[A](value: A)(implicit writer: JsonWriter[A]): Json = writer.write(value)
}

object JsonSyntax {
  implicit class JsonWriterOps[A](value: A) {
    def toJson(implicit writer: JsonWriter[A]) = writer.write(value)
  }
}

object JsonExample extends App {
  import JsonWriterInstances._

  val person = Person("Dave", "dave@google.com")

  println(Json.toJson(person))
  
  import JsonSyntax._
  println(person.toJson)
}
