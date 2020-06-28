package com.zhou.sparksql

import java.util.Properties

import org.apache.spark.sql.SparkSession
//hive是调用mapreduce完成任务,spark是调用spark case调用用任务
object SparkMysql extends App {

//  val spark=SparkSession.builder()
//    .appName("SparkMysql")
//    .master("local[1]")
//    .getOrCreate()
//
//  val prop=new Properties()
//  prop.setProperty("user","root")
//  prop.setProperty("password","root")
//  //val mysqlDF= spark.read.jdbc("jdbc:mysql://hadoop01:3306/company","staff",prop)
//  val datamysql=spark.read.jdbc("jdbc:mysql://192.168.60.134/HiveHbase","student",prop)
//  datamysql.show()
  val spark=SparkSession.builder()
  .appName("SparkMysql")
  .master("local[1]")
  .getOrCreate()

 val proper=new Properties()
  proper.setProperty("user","root")
  proper.setProperty("password","root")
  val sparkmysql=spark.read.jdbc("jdbc:mysql://192.168.60.134:3306/HiveHbase","student",proper)
  sparkmysql.show()
  spark.stop()
}
