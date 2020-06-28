package com.zhou.kafka;

import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

public class KafkaProducer {
    public static void main(String[] args) {
        Properties prop = new Properties();
        //指定broker的地址
        prop.put("bootstrap.servers","192.168.60.153:9092");
        prop.put("acks","1");
        prop.put("retries","3");
        //可以添加自定义分区
        //prop.put("partitioner.class","xxxxx");
        prop.put("key.serializer","org.apache.kafka.common.serialization.StringSerializer");
        prop.put("value.serializer","org.apache.kafka.common.serialization.StringSerializer");
        //创建一个producer
        org.apache.kafka.clients.producer.KafkaProducer<String, String> producer = new org.apache.kafka.clients.producer.KafkaProducer<String, String>(prop);
        for (int i=0;i<=100;i++){
            ProducerRecord<String, String> producerRecord = new ProducerRecord<String, String>("bosenrui13",i+" hellomax");

            producer.send(producerRecord);

        }
        
        producer.close();


    }

}
