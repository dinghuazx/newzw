package com.zhou.spark

  import org.apache.spark.streaming.{Seconds, StreamingContext}
  import org.apache.spark.{SparkConf, SparkContext}

object SparkStrea {

    def main(args: Array[String]): Unit = {


     val conf=new SparkConf().setAppName("SparkStrea").setMaster("local[1]")
     val sc=new SparkContext(conf)
//      sc.setLogLevel("ERROR")
//      val ssc=new StreamingContext(sc,Seconds(5))
//      //建立一个dstream
//      val ds=ssc.socketTextStream("crxy99",8693)
//
//      //val rdc=ds.map(x=>x.split(" ")).map(x=>(x,1)).reduceByKey()
//      //标准的输出
//      ds.print()
//      //执行开始
//      ssc.start()
//      //等待结束
//      ssc.awaitTermination()
      //当集合里有多个元素时要用到压缩在可以放在一起于下
      val rdd=sc.parallelize(List("hello bob hello jack hello jay hello bob",
      "hello tom jack jack joe jim rose"))
      val rdd2=rdd.flatMap(x=>x.split(" "))
      val rdd3=rdd2.map(x=>(x,1))
      val rdd4=rdd3.reduceByKey(_+_).saveAsTextFile("f://1703c")
      //println(rdd4.collect().toBuffer)


    }




}
