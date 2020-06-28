package com.zhou.yong

import org.apache.spark.{SparkConf,SparkContext}


object DayModena extends App {

  val conf=new SparkConf().setAppName("sparktest").setMaster("local[1]")
  val sc=new SparkContext(conf)
  var test=sc.textFile("f://dome.txt")
   val test2=test.map(x=>{
     val arr1=x.split(" ")
     val intby=arr1(3).toInt
     (arr1(0),arr1(1),arr1(2),intby)
  })
  val ter3=test2.sortBy(x=>x._4,false).take(1)
  println(ter3.toBuffer)
  //交易额总数
  val ter4=test2.map(x=>x._4).sum()
  println(ter4)
  //购买的总人数
  val ter5=test2.map(x=>x._1).distinct().count()
  println(ter5)

  //求出各产品交易额
  val ter6= test2.map(x=>(x._2,x._4)).groupByKey().map(x=>(x._1,x._2.sum))
  println(ter6.collect().toBuffer)
}
