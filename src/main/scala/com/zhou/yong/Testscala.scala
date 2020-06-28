package com.zhou.yong
//测试scala访问修饰符
class Testscala {
  var id = 1
  //在本包里都有效
  private var name = "王崇高杨"
  val sex = "男"
  //只在本类
  private[this] val data = "2020-02-06"
  //在com包下的所有类
 private[com] def m5() = {
    println("小子就是不一样")
  }

}
object Testscala {
  def main(args: Array[String]): Unit = {
   val p= new Testscala
   p.m5()
  val arr=Array(1,2,3,4,5,6,7,8,9,10)
    val maxarr=arr(0)
    for(i<-arr){
      if(maxarr<arr(i)){
        maxarr==arr(i)
      }
    }
    println(maxarr)


  }
}