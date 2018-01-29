package book.chapter2

object _1ADTs extends App {
  //In functional programming, bigger problems are solved by composing small functions
  //We know pure functions are compossible, so we want to only deal with pure functions for sure
  //Pure functions, are the one which operate on state and return a new state.
  //Thus it implies when we model a solution in FP, we keep state and behaviour separate
  //And these states are represented by ADT (Algebraic Data Types)
  //ADT is a representation of data simply by 'ands' and 'ors'
  //In below case Shape can be a Rectangle 'or' Circle aka sum type
  //an example of a product type can be Rectangle where rectangle has width 'and' height

  //An ADT contains of Type constructor and Data constructor
  //Type constructor are represented by trait and data constructors by case classed and objects

  sealed trait Shape
  final case class Rectangle(width: Double, height: Double) extends Shape
  final case class Circle(radius: Double) extends Shape
  //having a sealed trait for type constructor, tells the compiler that all possible
  //data constructors are in the same file thus exhaustive checking made easy (pattern matching complains by compiler)

  val rect: Shape = Rectangle(3.0, 4.0)
  val circle: Shape = Circle(1.0)

  //The best part of ADT is they are type safe, the compiler knows about our algebra
  def area(shape: Shape): Double =
    shape match {
      case Rectangle(w, h) => w * h
      case Circle(r) => math.Pi * r * r
    }

  println(area(rect))
  println(area(circle))

  //Note
  //More details on FP domain modelling can be found in book "Functional and reactive domain modelling" by Debasish Ghosh

}
