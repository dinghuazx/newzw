package com.zhou.spark

import org.apache.spark.{SparkConf,SparkContext}

object SparkGaoChao extends App {


  val conf=new SparkConf().setAppName("sparkdome").setMaster("local[1]")
  val sc=new SparkContext(conf)
  val ter=sc.textFile("f://data/agent.log").map(
    x=>{
     val data=x.split(" ")
      (data(1),data(4))
    }
  )
  val ter1=ter.groupByKey()
  val ter2=ter1.map(x=>{
    val uu=x._1
   val hh=x._2.map(x=>x+"_"+uu)
    (hh)
  })

//  val tr1=ter2.collect()
//  for(x<-0 to tr1.length){
//    val ter3=tr1(x)
//   (ter3)
//  }






}
