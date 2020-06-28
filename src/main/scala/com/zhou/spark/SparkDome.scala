package com.zhou.spark

import org.apache.spark.{SparkConf, SparkContext}

object SparkDome {

  def main(args: Array[String]): Unit = {
    val conf=new SparkConf().setAppName("sparkdemo").setMaster("local[2]")
    val sc=new SparkContext(conf)
    val res0=sc.textFile("f://data/dome.txt").map(_.split(",")).map(x=>(x,1))
    //res0.foreach(println())
    sc.stop()

    }

}
