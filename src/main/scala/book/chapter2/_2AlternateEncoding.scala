package book.chapter

object _2AlternateEncoding extends App {

  //Alternative encodings for ADT
  //'or' type by Either
  //'and' type by tuple
  
  type Rectangle = (Double, Double) //and type
  type Circle = Double
  type Shape = Either[Rectangle, Circle] //or type
  
  val rect: Shape = Left((3.0, 4.0))
  val circle: Shape = Right(1.0)

  def area(shape: Shape): Double =
    shape match {
      case Left((w, h)) => w * h
      case Right(r) => math.Pi * r * r
    }

  println(area(rect))
  println(area(circle))

  //This looks like a way instead of using trait, case classes and objects
  //But instead of using Tuple and Either, Shapeless uses heterogeneous list (HList) probably well explaned the why part in the book

  //An HList is either the empty list HNil, or a pair ::[H, T] where H is an arbitrary type and T is another HList

  //With HList below implementation can be used but there are more improvements, we will talk on those latter
  import shapeless._

  type HRectangle = Double :: Double :: HNil
  type HCircle = Double :: HNil
  type HShape = HList

}
