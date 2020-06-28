package com.zhou.sparksql

import org.apache.spark.sql.SparkSession

object SparkSqlApi extends App {

  val spark=SparkSession
    //开始
    .builder()
    .appName("sparkkill")
    .master("local[1]")
    //结束
    .getOrCreate()

  //建立sc对象读取文件
  val sc=spark.sparkContext
  //读取文件
  val rdd1=sc.textFile("f://data/dome.txt").map(x=>x.split(" "))
  //样列类就是不用new直接用
  val studentRDD=rdd1.map(x=>student(x(0).toInt,x(1),x(2).toInt))
  //导入才能在下面转换dataFrame时不报错
  import spark.implicits._
  //RDD转换dataFrame
  val de=studentRDD.toDF()
  //定义sql的一个View表名
  de.createTempView("student")
  //执行sql语句
  val ter=spark.sql("select id,name,age from student where age>20")
  ter.show()
  spark.stop()
}
case class student(id:Int,name:String,age:Int)