package com.zhou.yangliclass
//样例类  特点:自动序列化 不需要new
import scala.util.Random
//构造类
case class student(name:String,age:Int)
case class mouse(peculiarity:String)
case object teacher
object Test extends App {
  //类放入array里
  val arr=Array(student("小明",18),mouse("渐渐的呀"),teacher)
  val arr2=arr(Random.nextInt(arr.length))
  arr2 match {
    case student(name,age)=>println(s"$name,$age")
    case mouse(peculiarity)=>println(peculiarity)
    case teacher=>println("老师好")
  }
}
