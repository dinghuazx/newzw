package com.zhou.spark

import org.apache.spark.{SparkConf,SparkContext}

object SparkMC extends App{

    val conf=new SparkConf().setAppName("SparkMC").setMaster("local[1]")
    val sc=new SparkContext(conf)
  //只是在聚合不计算以初始值分割
//  val rdd2 = sc.parallelize(List(1, 3, 5,4), 2)
//  println(rdd2.aggregate("10")(_ + _, _ + _))


  //过滤范围类的值是按照key值过滤的也是按这字典顺序来排列比喻 a->c之间
val rdd1=sc.parallelize(List(("a",1),("b",2),("c",1),("a",10),("c",5)))
//val ter=rdd1.filterByRange("a","c")
//  println(ter.collect().toBuffer)

  //把map中所用的key都放在一起
//val ter1=rdd1.keys
//println(ter1.collect().toBuffer)
  //把map中所用的values值都放在一起
//val test2=rdd1.values
//println(test2.collect().toBuffer)

  //foldBykey,把key相同的折叠在一起
//val rdd=sc.parallelize(List("good","beautiful","she","Linux","tar"))
//  //(3,"she,tar")效果数据
//  val ter3=rdd.foldBykey("@")(_+_)
//  println()
//把List集合转换成map集合
  //Map(b -> 2, a -> 10, c -> 5)效果
  //在map中数据key值不能重复会覆盖数据
//val rdd2=sc.parallelize(List(("a",1),("b",2),("c",1),("a",10)))
//  val  map =rdd1.collectAsMap()
//  println(map)
  val func=(index:Int,iter:Iterator[Int])=>{
    iter.map(x=>(index,x))
  }
val rdd2=sc.parallelize(List(1,2,3,4,5,6,7),3)
val ter2=rdd2.mapPartitionsWithIndex(func)
println(ter2.collect().toBuffer)





}
