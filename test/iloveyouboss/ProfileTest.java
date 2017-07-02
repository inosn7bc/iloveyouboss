/***
 * Excerpted from "Pragmatic Unit Testing in Java with JUnit",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/utj2 for more book information.
***/
package iloveyouboss;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*; 
import org.junit.*;

/**
 * てすと2
 * 
 * @author sn1
 *
 */
public class ProfileTest {

	private Profile profile;
	private Question question;
	private Criteria criteria;
	
	@Before
	public void create(){
		profile = new Profile("Bull Hockey, Inc.");
		question = new BooleanQuestion(1, "ボーナスは支給されますかx?");
		criteria = new Criteria();
		
	}

	@Test
	public void test必須の条件にマッチしない場合_matchesはfalseを返す() {		
		profile.add(new Answer(question, Bool.FALSE));
		criteria.add(new Criterion(new Answer(question, Bool.TRUE), Weight.MustMatch));
		
		boolean matches = profile.matches(criteria);
		assertFalse(matches);
	}
	
	@Test
	@Ignore
	public void test不問の条件があれば_matchesはtrueを返すx() {
		profile.add(new Answer(question, Bool.FALSE));

		criteria.add(new Criterion(new Answer(question, Bool.TRUE), Weight.DontCare));

		boolean matches = profile.matches(criteria);
		assertTrue(matches);
	}

}
