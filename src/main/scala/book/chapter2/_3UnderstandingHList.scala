package book.chapter2

object _3UnderstandingHList extends App{
  //Say we create our own HList or heterogeneous list
  //This will make things more clear as how things are working

  //this is a very trivial example and its just for understanding
  //the actual implementations may be more complicated and detailed
  //lot of parts missing here, but gradually we will come to it

  trait HList
  final case class Cons[H,T](head:H, tail:T) extends HList
  final case object Nil extends HList

  val hList:HList = Cons(1,Cons("x",Cons(1.2, Nil)))

  print(hList)

  //Take away
  //HList is a encoding for product type
  //Though Product is a better name for HList but unfortunately there is already a class scala.Product
}
