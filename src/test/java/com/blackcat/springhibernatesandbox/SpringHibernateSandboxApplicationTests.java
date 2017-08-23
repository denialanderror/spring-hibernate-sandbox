package com.blackcat.springhibernatesandbox;

import com.blackcat.springhibernatesandbox.entity.Ball;
import com.blackcat.springhibernatesandbox.entity.Beach;
import com.blackcat.springhibernatesandbox.entity.Bucket;
import com.blackcat.springhibernatesandbox.entity.Parasol;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
public class SpringHibernateSandboxApplicationTests {

	@Autowired
	private BeachRepository beachRepository;

	@Test
	public void manyToAnyTests() {
		Ball ball = new Ball();
		ball.setName("Stripy beach ball");
		ball.setBounciness(5);

		Parasol parasol = new Parasol();
		parasol.setName("Tattered parasol");
		parasol.setOpacity(0.3);

		Bucket bucket = new Bucket();
		bucket.setName("Bucket full of sand");
		bucket.setFullOfSand(true);

		Beach beach = new Beach();
		beach.setName("World's Best Beach(tm)");
		beach.setBalls(Collections.singletonList(ball));
		beach.setBuckets(Collections.singletonList(bucket));
		beach.setParasols(Collections.singletonList(parasol));

		beachRepository.save(beach);

		System.out.println("Beach created!");

		assertEquals(beach, beachRepository.findByItemId(ball.getId()));

		System.out.println("Beach found!");

		assertEquals(ball, beach.getBalls().get(0));
		assertEquals(parasol, beach.getParasols().get(0));
		assertEquals(bucket, beach.getBuckets().get(0));
	}

}
