package com.zhou.yangliclass
//隐式参数,也可以理解为预定参数
object ImplicitConnect {
  implicit val foot1 ="mianbiao"
  implicit val foot2 = 25.5
  implicit val foot3 = 26
}
object Implicitcat1 {
  //定义一个方法就相当于在方法后面加了个隐式参数
  def ect()(implicit foot:String): Unit ={
    println(foot)
  }

  def main(args: Array[String]): Unit = {
    import ImplicitConnect._
    //当参数没有的时候就会去找预定好的参数
    ect()
  }
}