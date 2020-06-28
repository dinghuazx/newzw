package com.zhou.yong

import scala.collection.mutable.ListBuffer
import scala.util.Random

object ArrayDome extends App {


  //val arr=Array(1,3,4,5,7,9,10,11,18,20,21)
  //val arr1=arr.filter(x=>x%2==0).map(x=>x*9)
  //println(arr1.toBuffer)

 // def m2(s:(Int,Int)=>Int):Int={s(2,3)}
 // val func=(x:Int,b:Int)=>x+b
  // val func2=(x:Int,y:Int)=>x*y
  //val res=m2(func)
  //println(res)
 //val func3=(m:Int,n:Int)=>n*m
  //def m3(m:(Int,Int)=>Int):Int=m(5,6)
  //val tre=m3(func3)
 // println(tre)
  //定义一个方法
  def m1(a:Int,b:Int):Int=a*b
  //def m2(m:Int,n:Int):Int=m+n
  //定义一个函数
  //val func4=(m:Int,n:Int)=>n*m
  //val func5=(f:Int,g:Int)=>f*g
  //vel func4=(y:Int,x:Int)=>y+x
  //map函数可以统计每个单词出现的次数
  //group函数就是可以把array的数据按照第一位单词分组放入一Array数组第二值是
  //以字节形式放入到第二值
  //mapValues是算出值的个数以数组的形式返回
  //val word=Array("小明 大师 小菜 大师 明明 王者 先知 青铜 mj 王者 ss 青铜 jj 白银 罗 王者")
  //val che=word.flatMap(_.split(" ")).map(x=>(x,1)).groupBy(__1.).mapValues(_.toList.size)
  //println(che.toBuffer)

  val list=ListBuffer(1,2,3,4,5)
      list.+=(6)
  println(list)


  val list1=List(1,2,3,4,5,6,7,"max",8,9,"max",1,2,3)
  val list2=list1.slice(0,8)
  println(list2)

  val map1=Map(("wenxia",2),("xiakshd",52),("xiambei",19))
  println("-------map第一遍历--------------")
  for(x<- map1.keys) println(x+" -> "+map1(x))
  //for(x<-map1.keys) println(x+"->"+map1(x))
  println("-------map第二遍历--------------")
  for((x,y)<-map1){
    println(x+"->"+y)
  }

 //val arr=Array("祥康",52,3.14,66666f,true)
 //val m=arr(Random.nextInt(arr.length))
 //m match{
 // case a:String=>println("这是个string"+a)
 // case b:Float=>println("这是个浮点类型"+b)
 // case c:Boolean=>println("这是个布尔类型"+c)

 //}

 //val arr=Array("jack",3.14,5.666666f,10,true)
 //val m =arr(Random.nextInt(arr.length))
 //m match {
 // case a: String => println("这个是个string类型" + a)
 // case b: Int => println("这个是int类型" + b)
 // case c: Boolean => println("这个是布尔类型" + c)
 // case _ => println("其他类型")
// }
 //val ts = new ArrayBuffer[Int](5)
// ts.append(6,5,5)
 //指定下标添加数据
 //ts.insert(0,1)
// println(ts.toBuffer)
 val arr=Array(2,5,3,6,9,10,85)
 var max =arr(0);
//找出最大值
 for(m<- 1 to arr.length-1){
    if(arr(m)>max){
      max=arr(m)
    }
  println(max)
 }

//filter过滤数组中能被2整除的数
//map代表数组里的每一个数
 //x=>x%2代表每个数都除以2
 val arr1=Array(1,2,3,4,5,6,7,8,9,10)

 var arr2=arr1.filter(x=>x%2==0).map(x=>x*6)

 println(arr2.toBuffer);

for(i<- arr){
 if(i%2==0){
  val n=i*6
  println(n)
 }
}

 val m=Map("小明"->1,"小白"->2,("现货",52),"强哥"->20)
 val mkey=m.keys
 val mvalue=m.values
 val mget=m.get("小明")
println(mkey + "------"+mvalue+"-----"+mget)
 //map集合遍历,要想添加数据就要用mapBuffer
for(i<-m.keys){
 println(i+"->"+m(i))
  println(i)
}
 val list3 =List("mysql","flume","sqoop","hive","hbase")
 //把list集合转变成set集合
 val set = list3.toSet
 println(set)

 val po = list3.filter(x=>x=="mysql").map(x=>x+"小周学会了")
 println(po)

//元组的匹配
val tup=(5,9,6)
tup match{
 case (_,q,6) =>println(q)
 case (z,x,y)=>println(s"$z,$x,$y")
}

val name =Array(5,9,6)
val h=name(Random.nextInt(name.length))
 h match{
  case a:Int =>println("这是数字")

 }

  val arr9=Array(Array(Array("hello,tom,jerry,hello,hello,hello","hello,jerry,bob,jerry,hello")))
  val arr7=arr9(0)
  val arr6=arr7.flatten.flatMap(_.split(",")).map(x=>(x,1)).groupBy(x=>x._1).mapValues(x=>x.size)
  println(arr6.toBuffer)


}
