package com.qhli.demo.zookeeper.curator;

import java.util.List;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.AuthInfo;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.curator.retry.RetryNTimes;
import org.apache.curator.retry.RetryUntilElapsed;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.data.Stat;

public class GetData {

	public static void main(String[] args) throws Exception {
		
		//RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);
		//RetryPolicy retryPolicy = new RetryNTimes(5, 1000);
		RetryPolicy retryPolicy = new RetryUntilElapsed(5000, 1000);
//		CuratorFramework client = CuratorFrameworkFactory
//				.newClient("192.168.1.9:2181",5000,5000, retryPolicy);

		CuratorFramework client = CuratorFrameworkFactory
				.builder()
				.connectString("192.168.1.9:2181")
				.sessionTimeoutMs(5000)
				.connectionTimeoutMs(5000)
				.retryPolicy(retryPolicy)
				.build();
		
		client.start();
		
		Stat stat = new Stat();

		// 只获取数据
//		byte[] ret = client.getData().forPath("/curator");

//		获取数据时同时获取节点的状态信息
		byte[] ret = client.getData().storingStatIn(stat).forPath("/curator");
		
		System.out.println(new String(ret));
		
		System.out.println(stat);
		
		
	}
	
}
