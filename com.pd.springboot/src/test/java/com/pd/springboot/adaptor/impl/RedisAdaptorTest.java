package com.pd.springboot.adaptor.impl;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.pd.springboot.adaptor.IRedisAdaptor;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisAdaptorTest {

	@Autowired
	private IRedisAdaptor redisAdaptor;

	@Test
	public void test() throws Exception {
		redisAdaptor.delete("test.1");
		Assert.assertEquals(null, redisAdaptor.query("test.1"));
		redisAdaptor.set("test.1", "test1");
		Assert.assertEquals("test1", redisAdaptor.query("test.1"));
		redisAdaptor.delete("test.1");
	}

}
