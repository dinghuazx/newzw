package com.zhou.sparksql

import java.util.Properties

import org.apache.spark.sql.SparkSession

object SparkSqlDayOne extends App {

  val spark=SparkSession.builder()
    .appName("SparkSqlDayOne")
    .master("local[1]")
    .getOrCreate()


  val proper=new Properties()
  proper.setProperty("user","root")
  proper.setProperty("password","root")

  val rdd=spark.read.jdbc("jdbc:mysql://192.168.60.134:3306/HiveHbase","student",proper)
  rdd.show()

  spark.stop()
}
