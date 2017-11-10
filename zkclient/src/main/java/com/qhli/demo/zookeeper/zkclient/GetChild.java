package com.qhli.demo.zookeeper.zkclient;

import java.util.List;

import org.I0Itec.zkclient.ZkClient;
import org.I0Itec.zkclient.serialize.SerializableSerializer;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.data.Stat;

public class GetChild {

	public static void main(String[] args) {
		ZkClient zc = new ZkClient("192.168.1.9:2181",10000,10000,new SerializableSerializer());
		System.out.println("conneted ok!");
		
		List<String> cList = zc.getChildren("/zkclient");
		
		System.out.println(cList.toString());
		
	}
	
}
