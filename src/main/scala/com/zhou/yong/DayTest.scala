package com.zhou.yong

import org.apache.spark.{SparkConf, SparkContext}

object DayTest extends App {

  val conf=new SparkConf().setAppName("SparkAdmin").setMaster("local[1]")
  val sc=new SparkContext(conf)


    val file=sc.textFile("f://data/student.txt").map(x=>{
     val ter= x.split(" ")
      (ter(0),ter(1),ter(2),ter(3),ter(4),ter(5))
    }
    )
  // 一共有多少人参加考试
      val countname=file.groupBy(x=>x._2).count()
  //一共有多少个小于20岁的人参加考试
      val countname1=file.map(x=>(x._2,x._3)).filter(x=>x._2.toInt>20).distinct()
  //一共有多少个等于20岁的人参加考试
  val countname2=file.map(x=>(x._2,x._3)).filter(x=>x._2.toInt==20).distinct()
  //一共有多少个大于20岁的人参加考试
  val countname3=file.map(x=>(x._2,x._3)).filter(x=>x._2.toInt<20).distinct()

  println(countname)
  println(countname1.collect().toBuffer)
  println(countname2.collect().toBuffer)
  println(countname3.collect().toBuffer)

  val list1=sc.parallelize(List(("小周",1),("小美",1),("小青",2)))
  val list2=sc.parallelize(List(("小周",1),("小美",1),("小青",2)))

  val s=1000
  val cont=s*10
  val n=sc.parallelize(seq = 1 to cont,s).map({
    i=>
      def rondom:Double=java.lang.Math.random()
      val x=rondom*2-1
      val y=rondom*2-1
      if(x*x+y*y<1) 1 else 0
  }).reduce(_+_)
  println(4.0*n/cont)






}
