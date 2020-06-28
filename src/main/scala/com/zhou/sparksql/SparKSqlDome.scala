package com.zhou.sparksql

import org.apache.spark.sql.SparkSession

object SparKSqlDome extends App {

  val spark=SparkSession.builder()
    .appName("Sparkdome")
    .master("local[1]")
    .getOrCreate()
  val  sc=spark.sparkContext
  val rdd=sc.textFile("f://data.txt").map(x=>x.split(" "))
  val rdd1=rdd.map(x=>book(x(0).toInt,x(1),x(2).toDouble,x(3)))

}
case class book(id:Int,name:String,price:Double,bookname:String)