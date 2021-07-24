package mastercard;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.mastercard.TestingMain;

public class TestingMainTest {

	@Test
	public void hello() {
		TestingMain test = new TestingMain();
			assertTrue(test.testword());
	}
}
