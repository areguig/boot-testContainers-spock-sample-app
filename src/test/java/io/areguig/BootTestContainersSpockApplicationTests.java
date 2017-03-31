package io.areguig;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import io.areguig.sample.BootTestContainersSpockApplication;

import static org.junit.Assert.assertTrue;

@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@SpringBootTest(classes = BootTestContainersSpockApplication.class,webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BootTestContainersSpockApplicationTests {

	@Autowired
	ApplicationContext context;

	@Test
	public void contextLoads() {
		assertTrue(context.containsBean("bootTestContainersSpockApplication"));
	}

}
