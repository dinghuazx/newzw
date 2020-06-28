package com.zhou.kelihua

object KeliHua {
  def main(args: Array[String]): Unit = {
    def m2(name:String)(age:Int):Unit=name+age

    val tar=m2(name = "小周")(_)
    println(tar(18))
  }
}
