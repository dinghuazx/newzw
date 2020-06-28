package com.zhou.kafka;



import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.Arrays;
import java.util.Properties;

public class Comumer2 {
    public static void main(String[] args) {
        Properties props = new Properties();
        props.put("bootstrap.servers", "192.168.60.153:9092");
        //指定我们的消费组
        props.put("group.id", "jj");
        //允许自动提交我们的offset 偏移量   记录我们的消费的数据在哪一条，在kafka当中，先提交offset偏移量，再进行消费
        props.put("enable.auto.commit", "true");
        //指定每秒钟提交我们的offset
        props.put("auto.commit.interval.ms", "1000");
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        KafkaConsumer<String, String> consumer = new KafkaConsumer<String,String>(props);
        //  定于我们哪一类主题
        consumer.subscribe(Arrays.asList("bosenrui13"));
        while (true) {
            //通过poll主动拉取数据
            ConsumerRecords<String, String> records = consumer.poll(100);
            for (ConsumerRecord<String, String> record : records)
                // System.out.println("offset = %d, key = %s, value = %s%n", record.offset(), record.key(), record.value());
                System.out.printf("offset = %d, key = %s, value = %s%n", record.offset(), record.key(), record.value());
        }
    }
}
