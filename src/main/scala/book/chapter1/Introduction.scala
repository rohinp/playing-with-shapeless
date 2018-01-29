package book.chapter1

object Introduction extends App{

  //Redundant code for creating similar types
  case class Employee(name: String, number: Int, manager: Boolean)
  case class IceCream(name: String, numCherries: Int, inCone: Boolean)

  //Thus redundant code for serialization
  def employeeCsv(e: Employee): List[String] =
    List(e.name, e.number.toString, e.manager.toString)
  def iceCreamCsv(c: IceCream): List[String] =
    List(c.name, c.numCherries.toString, c.inCone.toString)


  //Using shapeless to make generic types
  //just a glimpse of the generic programming
  import shapeless._
  val genericEmployee: ::[String, ::[Int, ::[Boolean, HNil]]] = Generic[Employee].to(Employee("Dave", 123, manager = false))
  // genericEmployee: shapeless.::[String,shapeless.::[Int,shapeless.::[Boolean,shapeless.HNil]]] = Dave :: 123 :: false :: HNil
  val genericIceCream: ::[String, ::[Int, ::[Boolean, HNil]]] = Generic[IceCream].to(IceCream("Sundae", 1, inCone = false))
  // genericIceCream: shapeless.::[String,shapeless.::[Int,shapeless.::[Boolean,shapeless.HNil]]] = Sundae :: 1 :: false :: HNil


  //without understanding the details the way shapeless helps to make our functions generic is really powerful
  def genericCsv(gen: String :: Int :: Boolean :: HNil): List[String] =
    List(gen(0).toString, gen(1).toString, gen(2).toString)

  println(genericCsv(genericEmployee))
  println(genericCsv(genericIceCream))

}
