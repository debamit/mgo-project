package com.mgo.project;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mgo.project.MgoProjectApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MgoProjectApplication.class)
@WebAppConfiguration
public class MgoProjectApplicationTests {

	@Test
	public void contextLoads() {
	}

}
