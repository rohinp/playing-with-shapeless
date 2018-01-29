package book.chapter2

object _5CoProducts {
  import shapeless.{Coproduct, :+:, CNil, Inl, Inr}

  case class Red()
  case class Amber()
  case class Green()

  //this operation is like an 'or' operation
  //it means Red or Amber or Green
  //these are similar to Either types in scala
  type Light = Red :+: Amber :+: Green :+: CNil

  //Inl and Inr are similar to Left and Right of scala Either
  val red: Light = Inl(Red())
  // red: Light = Inl(Red())
  val green: Light = Inr(Inr(Inl(Green())))
  // green: Light = Inr(Inr(Inl(Green())))

  //switching with generic types
  import shapeless.Generic

  sealed trait Shape
  final case class Rectangle(width: Double, height: Double) extends Shape
  final case class Circle(radius: Double) extends Shape

  val gen = Generic[Shape]

  gen.to(Rectangle(3.0, 4.0))
  // res3: gen.Repr = Inl(Rectangle(3.0,4.0))
  gen.to(Circle(1.0))
  // res4: gen.Repr = Inr(Inl(Circle(1.0)))
}
