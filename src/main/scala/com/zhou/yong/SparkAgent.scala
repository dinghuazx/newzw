package com.zhou.yong

import org.apache.spark.{SparkConf,SparkContext}

object SparkAgent extends App {

  val conf = new SparkConf().setAppName("SparkTest").setMaster("local[1]")
  val sc = new SparkContext(conf)
  val ter = sc.textFile("f://data/agent.log").map(x=>{
    val data=x.split(" ")
    (data(2),data(4))
  })
  println(ter.collect().toBuffer)
  val value =ter.map(x => (x._1 + "-" + x._2, 1)).groupByKey().sortByKey().map(x=>(x._1,x._2.size))
  //    println(value)


    println(value.collect().toBuffer)









 // println(gt.collect().toBuffer.toString())




//  val  test=ter2.groupByKey()
//  val test1=test.collect().map(x=>(x._1,x._2.sum)).sortBy(x=>x._2).reverse
//  val test2=test1.take(3)
//  println(test1.toBuffer+"--------"+test2.toBuffer)




//object SparkAgent2 extends App {
//  val conf=new SparkConf().setAppName("SparkTest").setMaster("local[2]")
//  val sc=new SparkContext(conf)
//  val ter=sc.textFile("f://data/teacher.log").map(x=>{
//    val test=x.split("/")
//    (test(3))
//  })
//
//  val test1=ter.collect().map(x=>(x,1)).groupBy(x=>x._1).mapValues(x=>x.size)
//
//  //print(test1.toBuffer)



}
