package book.chapter2

import shapeless.HNil

object _4GenericSwitch extends App{
  //This is where we see how we can switch between Shapeless generic types and ADT

  import shapeless.Generic

  case class IceCream(name: String, numCherries: Int, inCone: Boolean)

  val iceCreamGen = Generic[IceCream]
  // iceCreamGen: shapeless.Generic[IceCream]{type Repr = shapeless.::[String,shapeless.::[Int,shapeless.::[Boolean,shapeless.HNil]]]} =anon$macro$4$1@745fe7b1

  val iceCream = IceCream("Sundae", 1, inCone = false)
  // iceCream: IceCream = IceCream(Sundae,1,false)
  val repr = iceCreamGen.to(iceCream)
  // repr: iceCreamGen.Repr = Sundae :: 1 :: false :: HNil
  val iceCream2 = iceCreamGen.from(repr)
  // iceCream2: IceCream = IceCream(Sundae,1,false)

  //The best part is if you have similar types in your ADT
  //you can use just one generation for different ADT representation

  case class Employee(name: String, number: Int, manager: Boolean)
  // Create an employee from an ice cream:
  val employee = Generic[Employee].from(Generic[IceCream].to(iceCream))
  // employee: Employee = Employee(Sundae,1,false)

  //As tuples in scala are also case classes, we can use Generics there
  val tupleGen = Generic[(String, Int, Boolean)]
  tupleGen.to(("Hello", 123, true))
  // res4: tupleGen.Repr = Hello :: 123 :: true :: HNil
  tupleGen.from("Hello" :: 123 :: true :: HNil)
  // res5: (String, Int, Boolean) = (Hello,123,true)

  //It also works with case classes of more than 22 fields:
  case class BigData(
                      a:Int,b:Int,c:Int,d:Int,e:Int,f:Int,g:Int,h:Int,i:Int,j:Int,
                      k:Int,l:Int,m:Int,n:Int,o:Int,p:Int,q:Int,r:Int,s:Int,t:Int,
                      u:Int,v:Int,w:Int)
  Generic[BigData].from(Generic[BigData].to(BigData(
    1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23)))
}
