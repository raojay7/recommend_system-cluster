package com.recommend_system.kafka;

import kafka.producer.Partitioner;
import kafka.utils.VerifiableProperties;


public class PartitionerDemo implements Partitioner {

	
    private VerifiableProperties verifiableProperties;

    public PartitionerDemo(VerifiableProperties verifiableProperties) {
        this.verifiableProperties=verifiableProperties;
    }

    public int partition(Object key, int numPartitions) {

        String strKey= (String) key;
        //根据userid的hashCode分区
        return strKey.hashCode()%numPartitions;
    }
}
